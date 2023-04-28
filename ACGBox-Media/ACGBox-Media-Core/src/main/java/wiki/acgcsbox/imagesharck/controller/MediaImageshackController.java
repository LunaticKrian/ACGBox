package wiki.acgcsbox.imagesharck.controller;

import cn.hutool.http.HttpStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import wiki.acgcsbox.constant.PageParams;
import wiki.acgcsbox.constant.Result;
import wiki.acgcsbox.imagesharck.model.dto.MediaImageshackDto;
import wiki.acgcsbox.imagesharck.model.po.MediaImageshack;
import wiki.acgcsbox.imagesharck.model.qo.MediaImageshackQo;
import wiki.acgcsbox.imagesharck.service.MediaImageshackService;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author Krian
 * @version 1.0
 * @description: TODO 图床接口，上传图片，下载图片，随机返回图片，返回分类图片...
 * @date 2023/4/4 0004 18:52
 */
@Api(value = "图床接口", tags = "图床操作")
@Slf4j
@RestController
@RequestMapping("/imageshack")
public class MediaImageshackController {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private MediaImageshackService mediaImageshackService;

    @ApiOperation(value = "上传图片", tags = "图床操作")
    @PostMapping("/add")
    public Result<MediaImageshackDto> upload(@RequestParam("multipartFile") MultipartFile multipartFile) throws IOException {
        // 接受数据然后封装DTO：
        MediaImageshackDto mediaImageshackDto = new MediaImageshackDto();
        String filename = multipartFile.getOriginalFilename();
        mediaImageshackDto.setFileName(filename)
                .setFileType(filename.substring(filename.lastIndexOf(".")));
        File tempFile = File.createTempFile(UUID.randomUUID().toString(), ".temp");
        multipartFile.transferTo(tempFile);
        MediaImageshackDto uploadResult = mediaImageshackService.upload(tempFile.getAbsolutePath(), mediaImageshackDto);
        return new Result<MediaImageshackDto>().setSuccess(true).setCode(HttpStatus.HTTP_OK).setData(uploadResult);
    }

    @ApiOperation(value = "获取图床图片详细信息", tags = "图床操作")
    @GetMapping("/image/{fileId}")
    public Result<MediaImageshackDto> getImageInfoById(@PathVariable String fileId) {
        return new Result<MediaImageshackDto>().setData(mediaImageshackService.getImageInfoById(fileId)).setMsg("查询成功！");
    }

    @ApiOperation(value = "获取图床图片列表", tags = "图床操作")
    @PostMapping("/list")
    public Result<List<MediaImageshack>> list(@Valid PageParams pageParams,
                                              @RequestBody MediaImageshackQo mediaImageshackQo) {
        return null;
    }


}
