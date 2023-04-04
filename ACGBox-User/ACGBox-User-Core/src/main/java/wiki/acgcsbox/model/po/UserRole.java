package wiki.acgcsbox.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;

/**
 * @author : XiaoBai
 * @apiNote :用户角色关联表
 * @date : 2023/4/4 21:31
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("acgbox_user_user_role")
public class UserRole extends BasePo{

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 角色ID
     */
    @Column(name = "role_id")
    private Integer roleId;
}
