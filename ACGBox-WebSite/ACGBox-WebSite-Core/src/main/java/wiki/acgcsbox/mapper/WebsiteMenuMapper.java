package wiki.acgcsbox.mapper;

import org.apache.ibatis.annotations.Mapper;
import wiki.acgcsbox.model.po.WebsiteMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 网站导航站点分类菜单表 Mapper 接口
 * </p>
 *
 * @author Krian
 */
@Mapper
public interface WebsiteMenuMapper extends BaseMapper<WebsiteMenu> {

}
