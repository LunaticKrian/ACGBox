package wiki.acgcsbox.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;
import wiki.acgcsbox.model.vo.UserVo;

import javax.persistence.Column;

/**
 * @author : XiaoBai
 * @apiNote : 用户表
 * @date : 2023/4/4 20:45
 */

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("acgbox_user_user")
public class User extends BasePo {

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
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 头像
     */
    @Column(name = "avatar")
    private String avatar;

    /**
     * 电话号码
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 性别
     */
    @Column(name = "gender")
    private Integer gender;

    /**
     * 国家
     */
    @Column(name = "country")
    private String country;

    /**
     * 省
     */
    @Column(name = "province")
    private String province;

    /**
     * 市
     */
    @Column(name = "city")
    private String city;

    /**
     * 区
     */
    @Column(name = "district")
    private String district;

    /**
     * 身份证号码
     */
    @Column(name = "id_number")
    private String idNumber;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 用户等级
     */
    @Column(name = "level")
    private Integer level;

    /**
     * 等级名称
     */
    @Column(name = "level_name")
    private String levelName;

    /**
     * 用户身份：0 普通用户 ，1 运营用户 ，2 管理用户
     */
    @Column(name = "user_identity")
    private Integer userIdentity;

    /**
     * 积分
     */
    @Column(name = "integral")
    private Integer integral;

    public UserVo toVo(User user) {
        UserVo vo = new UserVo();
        BeanUtils.copyProperties(user, vo);
        return vo;
    }
}
