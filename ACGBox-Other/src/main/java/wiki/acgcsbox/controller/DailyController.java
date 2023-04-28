package wiki.acgcsbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wiki.acgcsbox.constant.Result;
import wiki.acgcsbox.service.DailyService;

/**
 * @author Krian
 * @version 1.0
 * @description: 日常安排接口
 * @date 2023/4/12 0012 16:46
 */
@RestController
@RequestMapping("/daily")
public class DailyController {

    @Autowired
    private DailyService dailyService;

    @GetMapping("/eat")
    public Result<String> eatInfo() {
        return null;
    }
}
