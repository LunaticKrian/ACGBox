package wiki.acgcsbox.mapper;

import org.apache.ibatis.annotations.Mapper;
import wiki.acgcsbox.model.po.WebsiteSite;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 网站导航网站记录表 Mapper 接口
 * </p>
 *
 * @author Krian
 */
@Mapper
public interface WebsiteSiteMapper extends BaseMapper<WebsiteSite> {

}
