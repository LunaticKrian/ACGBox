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
public class UserLoginQo {

    @NotNull
    @ApiModelProperty("用户名称")
    private String userName;

    @NotNull
    @ApiModelProperty("密码")
    private String password;
}
