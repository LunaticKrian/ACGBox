package wiki.acgcsbox.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import wiki.acgcsbox.constent.Result;
import wiki.acgcsbox.mapper.WebsiteSiteMapper;
import wiki.acgcsbox.model.dto.WebsiteSiteDto;
import wiki.acgcsbox.model.po.WebsiteSite;
import wiki.acgcsbox.model.qo.PageParams;
import wiki.acgcsbox.model.qo.WebsiteSiteQo;
import wiki.acgcsbox.service.WebsiteSiteService;

import java.util.List;

/**
 * <p>
 * 网站导航网站记录表 服务实现类
 * </p>
 *
 * @author Krian
 */
@Slf4j
@Service
public class WebsiteSiteServiceImpl extends ServiceImpl<WebsiteSiteMapper, WebsiteSite> implements WebsiteSiteService {

    @Autowired
    private WebsiteSiteMapper websiteSiteMapper;

    @Override
    public Result<WebsiteSiteDto> add(WebsiteSiteDto websiteSiteDto) {

        // 插入数据库：
        int i = websiteSiteMapper.insert(websiteSiteDto);
        if (0 >= i) {
            return new Result<WebsiteSiteDto>().setCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).setErrorMsg("数据写入数据库失败！");
        }
        return new Result<WebsiteSiteDto>().setCode(HttpStatus.OK.value()).setMsg("新增数据成功！");
    }

    @Override
    public Result<List<WebsiteSite>> list(PageParams pageParams, WebsiteSiteQo websiteSiteQo) {
        // 设置查询条件：
        LambdaQueryWrapper<WebsiteSite> queryWrapper = new LambdaQueryWrapper<>();
        // 根据站点名称模糊查询：
        queryWrapper.like(StringUtils.hasLength(websiteSiteQo.getSiteName()), WebsiteSite::getSiteName, websiteSiteQo.getSiteName());

        // 分页查询：
        Page<WebsiteSite> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());
        Page<WebsiteSite> sitePage = websiteSiteMapper.selectPage(page, queryWrapper);
        // 获取查询记录：
        List<WebsiteSite> records = sitePage.getRecords();

        return new Result<List<WebsiteSite>>().setCode(HttpStatus.OK.value()).setMsg("查询数据成功！").setData(records);
    }

    @Override
    public Result<WebsiteSiteDto> info(Long siteId) {
        WebsiteSite websiteSite = websiteSiteMapper.selectOne(new LambdaQueryWrapper<WebsiteSite>().eq(WebsiteSite::getSiteId, siteId));
        WebsiteSiteDto websiteSiteDto = new WebsiteSiteDto();
        BeanUtils.copyProperties(websiteSite, websiteSiteDto);
        return new Result<WebsiteSiteDto>().setSuccess(true).setMsg("查询成功！").setData(websiteSiteDto);
    }
}
