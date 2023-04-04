package wiki.acgcsbox.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;

/**
 * @author : XiaoBai
 * @apiNote : 角色菜单关联表
 * @date : 2023/4/4 21:29
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("acgbox_user_role_menu")
public class RoleMenu extends BasePo{
    /**
     * 角色ID
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 菜单ID
     */
    @Column(name = "menu_id")
    private Integer menuId;
}
