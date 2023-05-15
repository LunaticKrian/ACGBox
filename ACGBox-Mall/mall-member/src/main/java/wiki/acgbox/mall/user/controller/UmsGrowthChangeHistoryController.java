package wiki.acgbox.mall.user.controller;

import java.util.Arrays;
import java.util.Map;

        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wiki.acgbox.mall.user.entity.UmsGrowthChangeHistoryEntity;
import wiki.acgbox.mall.user.service.UmsGrowthChangeHistoryService;
import wiki.acgbox.mall.common.utils.PageUtils;
import wiki.acgbox.mall.common.utils.R;


/**
 * �ɳ�ֵ�仯��ʷ��¼
 *
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 10:22:03
 */
@RestController
@RequestMapping("user/umsgrowthchangehistory")
public class UmsGrowthChangeHistoryController {
    @Autowired
    private UmsGrowthChangeHistoryService umsGrowthChangeHistoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
            public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = umsGrowthChangeHistoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
            public R info(@PathVariable("id") Long id) {
            UmsGrowthChangeHistoryEntity umsGrowthChangeHistory = umsGrowthChangeHistoryService.getById(id);

        return R.ok().put("umsGrowthChangeHistory", umsGrowthChangeHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
            public R save(@RequestBody UmsGrowthChangeHistoryEntity umsGrowthChangeHistory) {
            umsGrowthChangeHistoryService.save(umsGrowthChangeHistory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
            public R update(@RequestBody UmsGrowthChangeHistoryEntity umsGrowthChangeHistory) {
            umsGrowthChangeHistoryService.updateById(umsGrowthChangeHistory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
            public R delete(@RequestBody Long[] ids) {
            umsGrowthChangeHistoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
