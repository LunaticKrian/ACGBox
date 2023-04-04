package wiki.acgcsbox.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import wiki.acgcsbox.model.po.User;

/**
 * @author : XiaoBai
 * @apiNote : 用户mapper
 * @date : 2023/4/4 21:47
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
