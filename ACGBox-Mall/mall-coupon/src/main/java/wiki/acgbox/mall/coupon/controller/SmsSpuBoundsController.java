package wiki.acgbox.mall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wiki.acgbox.mall.coupon.entity.SmsSpuBoundsEntity;
import wiki.acgbox.mall.coupon.service.SmsSpuBoundsService;
import wiki.acgbox.mall.common.utils.PageUtils;
import wiki.acgbox.mall.common.utils.R;


/**
 * ��Ʒspu��������
 *
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 10:20:55
 */
@RestController
@RequestMapping("coupon/smsspubounds")
public class SmsSpuBoundsController {
    @Autowired
    private SmsSpuBoundsService smsSpuBoundsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
            public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = smsSpuBoundsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
            public R info(@PathVariable("id") Long id) {
            SmsSpuBoundsEntity smsSpuBounds = smsSpuBoundsService.getById(id);

        return R.ok().put("smsSpuBounds", smsSpuBounds);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
            public R save(@RequestBody SmsSpuBoundsEntity smsSpuBounds) {
            smsSpuBoundsService.save(smsSpuBounds);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
            public R update(@RequestBody SmsSpuBoundsEntity smsSpuBounds) {
            smsSpuBoundsService.updateById(smsSpuBounds);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
            public R delete(@RequestBody Long[] ids) {
            smsSpuBoundsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
