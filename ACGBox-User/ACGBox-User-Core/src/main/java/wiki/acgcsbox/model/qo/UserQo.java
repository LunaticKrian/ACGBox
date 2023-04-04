package wiki.acgcsbox.model.qo;

import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import wiki.acgcsbox.model.po.User;

/**
 * @author : XiaoBai
 * @apiNote : 用户信息VO
 * @date : 2023/4/4 21:53
 */


@Data
@Builder
@ApiModel(value = "用户信息QO")
public class UserQo {

    @NotNull
    @ApiModelProperty("用户名称")
    private String userName;

    @NotNull
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

    public User toPO(UserQo qo) {
        User user = new User();
        BeanUtils.copyProperties(qo, user);
        return user;
    }
}
