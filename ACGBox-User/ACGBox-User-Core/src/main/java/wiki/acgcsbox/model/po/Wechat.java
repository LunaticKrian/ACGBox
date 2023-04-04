package wiki.acgcsbox.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;

/**
 * @author : XiaoBai
 * @apiNote : 微信用户信息表
 * @date : 2023/4/4 21:32
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("acgbox_user_wechat")
public class Wechat extends BasePo {

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * APPID
     */
    @Column(name = "app_id")
    private String appId;

    /**
     * openId
     */
    @Column(name = "open_id")
    private String openId;

    /**
     * unionId
     */
    @Column(name = "union_id")
    private String unionId;

    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 性别
     */
    @Column(name = "gender")
    private Integer gender;

    /**
     * 城市
     */
    @Column(name = "city")
    private String city;

    /**
     * 国家
     */
    @Column(name = "country")
    private String country;

    /**
     * 头像
     */
    @Column(name = "avatar")
    private String avatar;

}