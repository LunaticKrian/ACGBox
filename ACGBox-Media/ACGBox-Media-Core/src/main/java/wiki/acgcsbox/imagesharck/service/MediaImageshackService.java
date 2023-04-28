package wiki.acgcsbox.imagesharck.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import wiki.acgcsbox.imagesharck.model.dto.MediaImageshackDto;
import wiki.acgcsbox.imagesharck.model.po.MediaImageshack;

/**
 * <p>
 * 图床记录表 服务类
 * </p>
 *
 * @author Krian
 * @since 2023-04-05
 */
@Service
public interface MediaImageshackService extends IService<MediaImageshack> {

    /**
     * 上传图床图片文件
     *
     * @param localFilePath      本地文件路径
     * @param mediaImageshackDto 图床图片传输对象
     * @return MediaImageshackDto 图床图片信息
     */
    MediaImageshackDto upload(String localFilePath, MediaImageshackDto mediaImageshackDto);

    /**
     * 根据文件Id获取文件信息
     *
     * @param fileId 文件ID
     * @return 文件封装对象
     */
    MediaImageshackDto getImageInfoById(String fileId);

}
