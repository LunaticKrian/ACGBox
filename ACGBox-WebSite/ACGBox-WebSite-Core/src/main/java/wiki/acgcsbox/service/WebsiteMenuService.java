package wiki.acgcsbox.service;

import wiki.acgcsbox.constant.Result;
import wiki.acgcsbox.model.dto.WebsiteMenuDto;
import wiki.acgcsbox.model.po.WebsiteMenu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 网站导航站点分类菜单表 服务类
 * </p>
 *
 * @author Krian
 * @since 2023-04-03
 */
public interface WebsiteMenuService extends IService<WebsiteMenu> {

    /**
     * 新增站点分类菜单
     *
     * @param websiteMenuDto 站点菜单信息
     * @return 响应结果
     */
    Result<WebsiteMenuDto> add(WebsiteMenuDto websiteMenuDto);
}
