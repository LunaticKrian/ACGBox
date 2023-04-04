package wiki.acgcsbox.service;

import com.baomidou.mybatisplus.extension.service.IService;
import wiki.acgcsbox.domain.Result;
import wiki.acgcsbox.model.po.User;
import wiki.acgcsbox.model.qo.UserLoginQo;
import wiki.acgcsbox.model.qo.UserQo;
import wiki.acgcsbox.model.vo.UserVo;

/**
 * @author : XiaoBai
 * @apiNote : 用户服务类
 * @date : 2023/4/4 21:43
 */
public interface UserService extends IService<User> {


    /**
     * 用户注册
     * @param qo 用户注册qo
     * @return boolean
     */
    Result<Boolean> register(UserQo qo);

    /**
     * 用户登录
     * @param qo 用户登录qo
     * @return UserVo 用户信息和token
     */
    Result<UserVo> login(UserLoginQo qo);
}
