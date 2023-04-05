package wiki.acgcsbox.imagesharck.model.po;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 图床记录表
 * </p>
 *
 * @author Krian
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value="MediaImageshack", description="图床记录表")
@TableName("acgbox_media_imageshack")
public class MediaImageshack implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "记录ID")
    private Long id;

    @ApiModelProperty(value = "文件ID，记录文件的MD5值")
    private String fileId;

    @ApiModelProperty(value = "图片分类")
    private Long menuId;

    @ApiModelProperty(value = "图片名")
    private String fileName;

    @ApiModelProperty(value = "文件类型")
    private String fileType;

    @ApiModelProperty(value = "图片标签")
    private String tags;

    @ApiModelProperty(value = "图片访问路径")
    private String url;

    @ApiModelProperty(value = "对象桶名")
    private String bucket;

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
