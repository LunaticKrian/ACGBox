package wiki.acgcsbox.model.po;

import java.time.LocalDateTime;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 网站导航站点分类菜单表
 * </p>
 *
 * @author Krian
 */
@ApiModel("站点分类菜单实体")
@Data
@TableName("acgbox_website_menu")
public class WebsiteMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("站点分类菜单ID")
    private Long menuId;

    /**
     * 站点用户ID
     */
    private Long userId;

    /**
     * 站点菜单名称
     */
    private String menuName;

    /**
     * 站点菜单分类图标
     */
    private String menuIcon;

    /**
     * 站点分类菜单父级ID
     */
    private Long parentId;

    /**
     * 站点分类菜单显示顺序
     */
    private Integer orderNumber;

    /**
     * 新增记录时间
     */
    private LocalDateTime createTime;

    /**
     * 修改记录时间
     */
    private LocalDateTime updateTime;

    /**
     * 新增记录用户ID
     */
    private Long createBy;

    /**
     * 跟新记录用户ID
     */
    private Long updateBy;

    /**
     * 逻辑删除状态：0 正常，1 删除
     */
    private Boolean deleteStatus;

    /**
     * 记录状态：0 正常，1 删除，-1 禁止
     */
    private Integer status;


}
