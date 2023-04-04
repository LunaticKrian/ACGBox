package wiki.acgcsbox.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author : XiaoBai
 * @apiNote : 用户信息VO
 * @date : 2023/4/4 21:53
 */


@Data
@ApiModel(value = "用户信息VO")
public class UserVo {

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("电话号码")
    private String phone;

    @ApiModelProperty("性别")
    private Integer gender;

    @ApiModelProperty("国家")
    private String country;

    @ApiModelProperty("省")
    private String province;

    @ApiModelProperty("市")
    private String city;

    @ApiModelProperty("区")
    private String district;

    @ApiModelProperty("身份证号码")
    private String idNumber;

    @ApiModelProperty("真实姓名")
    private String realName;

    @ApiModelProperty("用户等级")
    private Integer level;

    @ApiModelProperty("等级名称")
    private String levelName;

    @ApiModelProperty("用户身份：0 普通用户 ，1 运营用户 ，2 管理用户")
    private Integer userIdentity;

    @ApiModelProperty("积分")
    private Integer integral;

    @ApiModelProperty("用户token")
    private String token;
}
