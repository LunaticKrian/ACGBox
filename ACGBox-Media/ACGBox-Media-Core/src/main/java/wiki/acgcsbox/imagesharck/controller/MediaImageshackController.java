package wiki.acgcsbox.imagesharck.controller;

import cn.hutool.http.HttpStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import wiki.acgcsbox.constent.Result;
import wiki.acgcsbox.imagesharck.model.dto.MediaImageshackDto;
import wiki.acgcsbox.imagesharck.service.MediaImageshackService;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Krian
 * @version 1.0
 * @description: TODO 图床接口，上传图片，下载图片，随机返回图片，返回分类图片...
 * @date 2023/4/4 0004 18:52
 */
@Api(value = "图床接口", tags = "图床文件操作")
@Slf4j
@RestController
@RequestMapping("/imageshack")
public class MediaImageshackController {

    @Autowired
    private MediaImageshackService mediaImageshackService;

    @ApiOperation(value = "上传图片", tags = "图床文件操作")
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

}
