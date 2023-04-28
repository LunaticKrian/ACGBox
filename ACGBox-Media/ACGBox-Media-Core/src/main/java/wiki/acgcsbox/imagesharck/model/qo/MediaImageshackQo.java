package wiki.acgcsbox.imagesharck.model.qo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 查询封装条件
 * </p>
 *
 * @author Krian
 */
@Data
@ApiModel(value = "MediaImageshackQo", description = "图床查询条件封装类")
public class MediaImageshackQo {

    @ApiModelProperty(value = "图片分类")
    private Long menuId;

    @ApiModelProperty(value = "图片名")
    private String fileName;

    @ApiModelProperty(value = "文件类型")
    private String fileType;

    @ApiModelProperty(value = "图片标签")
    private String tags;

    @ApiModelProperty(value = "图片浏览次数")
    private Integer clickCount;

    @ApiModelProperty(value = "图片上传时间")
    private LocalDateTime uploadTime;

    @ApiModelProperty(value = "图片备注")
    private String remark;

    @ApiModelProperty(value = "图片状态：0：正常；1：删除；-1：禁用")
    private Integer status;

    @ApiModelProperty(value = "逻辑删除：0 正常；1 删除")
    private Boolean deleteStatus;
}
