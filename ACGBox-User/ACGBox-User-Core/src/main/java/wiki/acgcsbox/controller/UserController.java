package wiki.acgcsbox.controller;

import cn.hutool.core.lang.Assert;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wiki.acgcsbox.domain.Result;
import wiki.acgcsbox.model.qo.UserLoginQo;
import wiki.acgcsbox.model.qo.UserQo;
import wiki.acgcsbox.model.vo.UserVo;
import wiki.acgcsbox.service.UserService;

/**
 * @author : XiaoBai
 * @apiNote :
 * @date : 2023/4/4 21:41
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Result<Boolean> register(@RequestBody UserQo qo) {
        Assert.isNull(qo, "用户信息不得为空");
        return userService.register(qo);
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result<UserVo> login(@RequestBody UserLoginQo qo){
        return userService.login(qo);
    }

}
