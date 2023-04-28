package wiki.acgcsbox.imagesharck.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import wiki.acgcsbox.exception.ACGCSBoxException;
import wiki.acgcsbox.imagesharck.mapper.MediaImageshackMapper;
import wiki.acgcsbox.imagesharck.model.dto.MediaImageshackDto;
import wiki.acgcsbox.imagesharck.model.po.MediaImageshack;
import wiki.acgcsbox.imagesharck.service.MediaImageshackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static wiki.acgcsbox.constant.RedisConstant.IMAGESHACK_PREFIX;

/**
 * <p>
 * 图床记录表 服务实现类
 * </p>
 *
 * @author Krian
 */
@Slf4j
@Service
public class MediaImageshackServiceImpl extends ServiceImpl<MediaImageshackMapper, MediaImageshack> implements MediaImageshackService {

    @Value("${minio.bucket.imageshack}")
    private String BUCKET_IMAGESHACK;

    @Value("${minio.host}")
    private String MINIO_HOST;

    @Autowired
    private MinioClient minioClient;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private MediaImageshackMapper mediaImageshackMapper;

    @Override
    public MediaImageshackDto upload(String localFilePath, MediaImageshackDto mediaImageshackDto) {
        // 获取文件的后缀名：
        String fileName = mediaImageshackDto.getFileName();
        String extension = fileName.substring(fileName.lastIndexOf("."));
        // 获取文件的保存Bucket路径：
        String defaultFolderPath = getDefaultFolderPath();
        // 获取文件的MD5值：
        String fileMD5 = getFileMD5(new File(localFilePath));
        // 生成文件在Minio上的对象存储全限定名：
        String objectName = defaultFolderPath + fileMD5 + extension;

        // 判断文件是否存在记录中（数据表中）
        LambdaQueryWrapper<MediaImageshack> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MediaImageshack::getFileId, fileMD5);
        MediaImageshack mediaImageshackFromDB = mediaImageshackMapper.selectOne(queryWrapper);
        if (mediaImageshackFromDB != null) {
            BeanUtils.copyProperties(mediaImageshackDto, mediaImageshackFromDB);
            // 文件已经上传到对象存储服务器，跟新数据库信息即可：
            MediaImageshack mediaImageshack = UpdateMediaFilesToDb(fileMD5, BUCKET_IMAGESHACK, objectName, mediaImageshackFromDB);
            BeanUtils.copyProperties(mediaImageshack, mediaImageshackDto);
            return mediaImageshackDto;
        }

        // 上传文件到Minio：
        boolean b = uploadFileToMinio(localFilePath, BUCKET_IMAGESHACK, objectName);
        if (!b) {
            log.error("上传图床文件失败！文件信息：localFilePath：{}, bucket：{}，对象名称：{}", localFilePath, BUCKET_IMAGESHACK, objectName);
        }

        MediaImageshack mediaImageshack = insertMediaFilesToDb(fileMD5, BUCKET_IMAGESHACK, objectName, mediaImageshackDto);
        BeanUtils.copyProperties(mediaImageshack, mediaImageshackDto);
        return mediaImageshackDto;
    }

    @Override
    public MediaImageshackDto getImageInfoById(String fileId) {
        // 获取Redis的操作合集对象：
        ValueOperations valueOperations = redisTemplate.opsForValue();
        // 查询缓存：
        String obj = (String) valueOperations.get(IMAGESHACK_PREFIX + fileId);
        if (obj != null) {
            // 解析JSON，返回对象即可：
            log.info("---执行缓存查询：{}---", obj);
            // 使用fastjson解析JSON字符串：
            MediaImageshack mediaImageshack = JSON.parseObject(obj, MediaImageshack.class);
            MediaImageshackDto mediaImageshackDto = new MediaImageshackDto();
            BeanUtils.copyProperties(mediaImageshack, mediaImageshackDto);
            return mediaImageshackDto;
        }
        // 查询缓存失败，从数据库中获取：
        MediaImageshack mediaImageshack = mediaImageshackMapper.selectOne(new LambdaQueryWrapper<MediaImageshack>().eq(MediaImageshack::getFileId, fileId));
        // 使用FastJSON解析对象：
        String jsonString = JSON.toJSONString(mediaImageshack);
        // 将查询结果写入缓存：
        valueOperations.set(IMAGESHACK_PREFIX + fileId, jsonString);
        MediaImageshackDto mediaImageshackDto = new MediaImageshackDto();
        BeanUtils.copyProperties(mediaImageshack, mediaImageshackDto);
        return mediaImageshackDto;
    }

    @Transactional
    public MediaImageshack insertMediaFilesToDb(String fileId, String bucket, String objectName, MediaImageshack mediaImageshack) {
        // 插入数据库记录：
        // 设置记录属性：
        mediaImageshack.setBucket(bucket)
                .setUrl(MINIO_HOST + bucket + "/" + objectName)
                .setFileId(fileId);
        int i = mediaImageshackMapper.insert(mediaImageshack);
        if (i <= 0) {
            ACGCSBoxException.cast("图床文件记录失败！");
        }
        // 查询数据库记录：
        return mediaImageshackMapper.selectOne(new LambdaQueryWrapper<MediaImageshack>().eq(MediaImageshack::getFileId, fileId));
    }

    @Transactional
    public MediaImageshack UpdateMediaFilesToDb(String fileId, String bucket, String objectName, MediaImageshack mediaImageshack) {
        // 插入数据库记录：
        // 设置记录属性：
        mediaImageshack.setBucket(bucket)
                .setUrl(MINIO_HOST + bucket + "/" + objectName)
                .setFileId(fileId);
        int i = mediaImageshackMapper.update(mediaImageshack, new LambdaQueryWrapper<MediaImageshack>().eq(MediaImageshack::getFileId, fileId));
        if (i <= 0) {
            ACGCSBoxException.cast("图床文件记录失败！");
        }
        // 查询数据库记录：
        return mediaImageshackMapper.selectOne(new LambdaQueryWrapper<MediaImageshack>().eq(MediaImageshack::getFileId, fileId));
    }

    /**
     * 根据日志获取默认的Bucket目录名
     *
     * @return Bucket目录名
     */
    private String getDefaultFolderPath() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "/";
    }

    /**
     * 获取文件的MD5值
     *
     * @param file 文件
     * @return String 文件的MD5值
     */
    private String getFileMD5(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            // 转换文件的MD5值：
            return DigestUtils.md5DigestAsHex(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取文件MD5值异常：{}", e.getMessage());
        }
        return null;
    }

    /**
     * 上传文件
     *
     * @param localFilePath 本地文件路径
     * @param bucket        桶名
     * @param objectName    存储对象名
     * @return boolean 上传文件是否成功
     */
    public boolean uploadFileToMinio(String localFilePath, String bucket, String objectName) {
        try {
            // 封装文件上传对象信息：
            UploadObjectArgs uploadObjectArgs = UploadObjectArgs.builder().
                    bucket(bucket)
                    .filename(localFilePath)
                    .object(objectName)
                    .build();
            // 上传文件：
            minioClient.uploadObject(uploadObjectArgs);
            log.info("上传文件成功，bucket：{}，objectName：{}", bucket, objectName);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("上传文件错误，bucket：{}，objectName：{}，错误信息：{}", bucket, objectName, e.getMessage());
        }
        return false;
    }
}
