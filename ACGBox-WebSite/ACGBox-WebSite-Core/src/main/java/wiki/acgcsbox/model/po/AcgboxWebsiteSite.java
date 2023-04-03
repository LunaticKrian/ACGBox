package wiki.acgcsbox.model.po;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 网站导航网站记录表
 * </p>
 *
 * @author Krian
 */
@Data
@TableName("acgbox_website_site")
public class AcgboxWebsiteSite implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 站点主键ID
     */
    private Long siteId;

    /**
     * 站点分类菜单ID
     */
    private Long menuId;

    /**
     * 站点用户ID
     */
    private Long userId;

    /**
     * 站点名称
     */
    private String siteName;

    /**
     * 站点logo图片地址
     */
    private String siteLogoPath;

    /**
     * 站点描述信息
     */
    private String siteDescription;

    /**
     * 站点URL地址
     */
    private String siteUrl;

    /**
     * 站点点击量
     */
    private Integer clickCount;

    /**
     * 站点显示顺序
     */
    private Integer orderNum;

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
