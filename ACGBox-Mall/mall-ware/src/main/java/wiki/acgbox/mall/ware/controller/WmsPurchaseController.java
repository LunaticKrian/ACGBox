package wiki.acgbox.mall.ware.controller;

import java.util.Arrays;
import java.util.Map;

        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wiki.acgbox.mall.ware.entity.WmsPurchaseEntity;
import wiki.acgbox.mall.ware.service.WmsPurchaseService;
import wiki.acgbox.mall.common.utils.PageUtils;
import wiki.acgbox.mall.common.utils.R;


/**
 * �ɹ���Ϣ
 *
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 10:23:04
 */
@RestController
@RequestMapping("ware/wmspurchase")
public class WmsPurchaseController {
    @Autowired
    private WmsPurchaseService wmsPurchaseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
            public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = wmsPurchaseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
            public R info(@PathVariable("id") Long id) {
            WmsPurchaseEntity wmsPurchase = wmsPurchaseService.getById(id);

        return R.ok().put("wmsPurchase", wmsPurchase);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
            public R save(@RequestBody WmsPurchaseEntity wmsPurchase) {
            wmsPurchaseService.save(wmsPurchase);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
            public R update(@RequestBody WmsPurchaseEntity wmsPurchase) {
            wmsPurchaseService.updateById(wmsPurchase);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
            public R delete(@RequestBody Long[] ids) {
            wmsPurchaseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
