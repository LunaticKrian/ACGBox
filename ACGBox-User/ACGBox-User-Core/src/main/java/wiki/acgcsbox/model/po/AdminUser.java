package wiki.acgcsbox.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;

/**
 * @author : XiaoBai
 * @apiNote : 管理后台用户表
 * @date : 2023/4/4 21:14
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("acgbox_user_admin_user")
public class AdminUser extends BasePo {

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 电话号码
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 头像
     */
    @Column(name = "avatar")
    private String avatar;

    /**
     * 可用标识：0 可用，1 不可用
     */
    @Column(name = "available")
    private Integer available;

    /**
     * APPID
     */
    @Column(name = "app_id")
    private String appId;
}
