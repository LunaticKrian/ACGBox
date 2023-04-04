package wiki.acgcsbox.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wiki.acgcsbox.domain.Result;
import wiki.acgcsbox.enums.ResultCodeEnum;
import wiki.acgcsbox.mapper.UserMapper;
import wiki.acgcsbox.model.po.User;
import wiki.acgcsbox.model.qo.UserLoginQo;
import wiki.acgcsbox.model.qo.UserQo;
import wiki.acgcsbox.model.vo.UserVo;
import wiki.acgcsbox.service.UserService;

import java.util.Objects;

/**
 * @author : XiaoBai
 * @apiNote : 用户服务实现类
 * @date : 2023/4/4 21:50
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private UserMapper userMapper;

    @Override
    public Result<Boolean> register(UserQo qo) {
        User user = qo.toPO(qo);
        int insert = userMapper.insert(user);
        if (insert == 1) {
            return Result.success(ResultCodeEnum.OK.getMsg(), true);
        } else {
            return Result.failure(ResultCodeEnum.REGISTER_FAILED.getCode(),
                    ResultCodeEnum.REGISTER_FAILED.getMsg());
        }
    }

    @Override
    public Result<UserVo> login(UserLoginQo qo) {
        LambdaQueryWrapper<User> query = Wrappers.<User>lambdaQuery().eq(User::getUserName, qo.getUserName())
                .eq(User::getPassword, qo.getPassword());
        User user = userMapper.selectOne(query);
        if (Objects.nonNull(user)) {
            return Result.success(user.toVo(user));
        } else {
            return null;
        }
    }
}
