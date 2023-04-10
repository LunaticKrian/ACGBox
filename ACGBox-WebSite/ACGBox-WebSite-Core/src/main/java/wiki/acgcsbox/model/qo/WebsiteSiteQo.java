package wiki.acgcsbox.model.qo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Krian
 * @version 1.0
 * @description: 站点信息查询类
 * @date 2023/4/10 0010 15:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebsiteSiteQo {

    // 站点ID：
    private Long siteId;

    // 站点名称：
    private String siteName;

    private Integer userId;

    private Integer CreateBy;

    private Integer menuId;

    private int status;
}
