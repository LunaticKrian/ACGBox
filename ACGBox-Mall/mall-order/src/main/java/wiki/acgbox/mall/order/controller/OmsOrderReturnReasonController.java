package wiki.acgbox.mall.order.controller;

import java.util.Arrays;
import java.util.Map;

        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wiki.acgbox.mall.order.entity.OmsOrderReturnReasonEntity;
import wiki.acgbox.mall.order.service.OmsOrderReturnReasonService;
import wiki.acgbox.mall.common.utils.PageUtils;
import wiki.acgbox.mall.common.utils.R;


/**
 * �˻�ԭ��
 *
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 09:31:10
 */
@RestController
@RequestMapping("order/omsorderreturnreason")
public class OmsOrderReturnReasonController {
    @Autowired
    private OmsOrderReturnReasonService omsOrderReturnReasonService;

    /**
     * 列表
     */
    @RequestMapping("/list")
            public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = omsOrderReturnReasonService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
            public R info(@PathVariable("id") Long id) {
            OmsOrderReturnReasonEntity omsOrderReturnReason = omsOrderReturnReasonService.getById(id);

        return R.ok().put("omsOrderReturnReason", omsOrderReturnReason);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
            public R save(@RequestBody OmsOrderReturnReasonEntity omsOrderReturnReason) {
            omsOrderReturnReasonService.save(omsOrderReturnReason);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
            public R update(@RequestBody OmsOrderReturnReasonEntity omsOrderReturnReason) {
            omsOrderReturnReasonService.updateById(omsOrderReturnReason);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
            public R delete(@RequestBody Long[] ids) {
            omsOrderReturnReasonService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
