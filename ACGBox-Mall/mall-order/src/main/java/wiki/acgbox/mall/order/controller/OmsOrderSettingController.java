package wiki.acgbox.mall.order.controller;

import java.util.Arrays;
import java.util.Map;

        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wiki.acgbox.mall.order.entity.OmsOrderSettingEntity;
import wiki.acgbox.mall.order.service.OmsOrderSettingService;
import wiki.acgbox.mall.common.utils.PageUtils;
import wiki.acgbox.mall.common.utils.R;


/**
 * ����������Ϣ
 *
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 09:31:10
 */
@RestController
@RequestMapping("order/omsordersetting")
public class OmsOrderSettingController {
    @Autowired
    private OmsOrderSettingService omsOrderSettingService;

    /**
     * 列表
     */
    @RequestMapping("/list")
            public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = omsOrderSettingService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
            public R info(@PathVariable("id") Long id) {
            OmsOrderSettingEntity omsOrderSetting = omsOrderSettingService.getById(id);

        return R.ok().put("omsOrderSetting", omsOrderSetting);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
            public R save(@RequestBody OmsOrderSettingEntity omsOrderSetting) {
            omsOrderSettingService.save(omsOrderSetting);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
            public R update(@RequestBody OmsOrderSettingEntity omsOrderSetting) {
            omsOrderSettingService.updateById(omsOrderSetting);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
            public R delete(@RequestBody Long[] ids) {
            omsOrderSettingService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
