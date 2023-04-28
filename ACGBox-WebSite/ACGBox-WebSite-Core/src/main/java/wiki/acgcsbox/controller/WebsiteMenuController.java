package wiki.acgcsbox.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wiki.acgcsbox.constant.Result;
import wiki.acgcsbox.model.dto.WebsiteMenuDto;
import wiki.acgcsbox.service.WebsiteMenuService;
import wiki.acgcsbox.util.TimeUtils;

/**
 * <p>
 * 网站导航站点分类菜单表 前端控制器
 * </p>
 *
 * @author Krian
 */
@Api(value = "站点分类API", tags = "站点分类菜单")
@Slf4j
@RestController
@RequestMapping("/website/menu")
public class WebsiteMenuController {

    @Autowired
    private WebsiteMenuService websiteMenuService;

    @ApiOperation(value = "新增站点分类", tags = "站点分类菜单")
    @PostMapping("/add/{userId}")
    public Result<WebsiteMenuDto> addMenu(@PathVariable("userId") String userId, @RequestBody WebsiteMenuDto websiteMenuDto) {
        log.info("------ 创建新建站点菜单，请求用户id：{} ------ {}", userId, TimeUtils.getLocalTime());
        return websiteMenuService.add(websiteMenuDto);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
