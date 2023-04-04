package wiki.acgcsbox.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;

/**
 * @author : XiaoBai
 * @apiNote : 管理后台菜单表
 * @date : 2023/4/4 21:16
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("acgbox_user_admin_menu")
public class AdminMenu extends BasePo {

    /**
     * 父级ID
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 菜单编号
     */
    @Column(name = "menu_code")
    private String menuCode;

    /**
     * 菜单分类ID
     */
    @Column(name = "menu_classify_id")
    private Integer menuClassifyId;

    /**
     * 菜单分类名称
     */
    @Column(name = "menu_classify_name")
    private String menuClassifyName;

    /**
     * 启用标识：0 未启用，1 启用
     */
    @Column(name = "top_status")
    private Integer topStatus;
}
