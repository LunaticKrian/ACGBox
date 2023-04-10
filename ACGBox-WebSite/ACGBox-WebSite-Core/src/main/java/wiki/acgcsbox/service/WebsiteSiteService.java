package wiki.acgcsbox.service;

import org.springframework.web.bind.annotation.RequestBody;
import wiki.acgcsbox.constent.Result;
import wiki.acgcsbox.model.dto.WebsiteMenuDto;
import wiki.acgcsbox.model.dto.WebsiteSiteDto;
import wiki.acgcsbox.model.po.WebsiteSite;
import com.baomidou.mybatisplus.extension.service.IService;
import wiki.acgcsbox.model.qo.PageParams;
import wiki.acgcsbox.model.qo.WebsiteSiteQo;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 网站导航网站记录表 服务类
 * </p>
 *
 * @author Krian
 * @since 2023-04-03
 */
public interface WebsiteSiteService extends IService<WebsiteSite> {

    /**
     * 新增站点信息
     *
     * @param websiteSiteDto 站点信息
     * @return Result<WebsiteSiteDto>
     */
    Result<WebsiteSiteDto> add(WebsiteSiteDto websiteSiteDto);

    /**
     * 分页查询站点信息
     *
     * @param pageParams    分页信息
     * @param websiteSiteQo 查询信息
     * @return Result<List < WebsiteSiteDto>>
     */
    Result<List<WebsiteSite>> list(PageParams pageParams, WebsiteSiteQo websiteSiteQo);

    /**
     * 根据ID查询站点信息
     *
     * @param siteId 站点ID
     * @return Result<WebsiteSiteDto>
     */
    Result<WebsiteSiteDto> info(Long siteId);
}
