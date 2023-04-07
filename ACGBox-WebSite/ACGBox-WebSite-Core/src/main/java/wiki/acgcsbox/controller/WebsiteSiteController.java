package wiki.acgcsbox.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wiki.acgcsbox.service.AcgboxWebsiteSiteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 网站导航网站记录表 前端控制器
 * </p>
 *
 * @author Krian
 */
@Slf4j
@RestController
@RequestMapping("/website")
public class WebsiteSiteController {

    @Autowired
    private AcgboxWebsiteSiteService acgboxWebsiteSiteService;
}
