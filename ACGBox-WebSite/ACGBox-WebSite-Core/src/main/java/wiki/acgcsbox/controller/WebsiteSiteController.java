package wiki.acgcsbox.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wiki.acgcsbox.constant.Result;
import wiki.acgcsbox.model.po.WebsiteSite;
import wiki.acgcsbox.model.qo.PageParams;
import wiki.acgcsbox.model.dto.WebsiteSiteDto;
import wiki.acgcsbox.model.qo.WebsiteSiteQo;
import wiki.acgcsbox.service.WebsiteSiteService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 网站导航网站记录表 前端控制器
 * </p>
 *
 * @author Krian
 */
@Api(value = "站点API", tags = "站点信息")
@Slf4j
@RestController
@RequestMapping("/website/site")
public class WebsiteSiteController {

    @Autowired
    private WebsiteSiteService websiteSiteService;

    @ApiOperation(value = "新增站点信息", tags = "站点信息")
    @PostMapping("/add")
    public Result<WebsiteSiteDto> addSite(WebsiteSiteDto websiteSiteDto) {
        return websiteSiteService.add(websiteSiteDto);
    }

    @ApiOperation(value = "根据ID查询站点信息", tags = "站点信息")
    @ApiParam(value = "siteId", example = "1", required = true)
    @GetMapping("/id/{siteId}")
    public Result<WebsiteSiteDto> InfoSite(@PathVariable("siteId") @NotNull Long siteId) {
        return websiteSiteService.info(siteId);
    }

    @ApiOperation(value = "查询站点信息列表", tags = "站点信息")
    @PostMapping("/list")
    public Result<List<WebsiteSite>> listSites(@Valid PageParams pageParams, @RequestBody WebsiteSiteQo websiteSiteQo) {
        return websiteSiteService.list(pageParams, websiteSiteQo);
    }
}
