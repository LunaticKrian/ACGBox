package wiki.acgcsbox.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;

/**
 * @author : XiaoBai
 * @apiNote :角色表
 * @date : 2023/4/4 21:28
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("acgbox_user_role")
public class Role extends  BasePo{

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;
}
