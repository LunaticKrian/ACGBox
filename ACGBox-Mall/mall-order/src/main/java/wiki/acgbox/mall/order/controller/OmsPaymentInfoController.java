package wiki.acgbox.mall.order.controller;

import java.util.Arrays;
import java.util.Map;

        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wiki.acgbox.mall.order.entity.OmsPaymentInfoEntity;
import wiki.acgbox.mall.order.service.OmsPaymentInfoService;
import wiki.acgbox.mall.common.utils.PageUtils;
import wiki.acgbox.mall.common.utils.R;


/**
 * ֧����Ϣ��
 *
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 09:31:09
 */
@RestController
@RequestMapping("order/omspaymentinfo")
public class OmsPaymentInfoController {
    @Autowired
    private OmsPaymentInfoService omsPaymentInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
            public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = omsPaymentInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
            public R info(@PathVariable("id") Long id) {
            OmsPaymentInfoEntity omsPaymentInfo = omsPaymentInfoService.getById(id);

        return R.ok().put("omsPaymentInfo", omsPaymentInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
            public R save(@RequestBody OmsPaymentInfoEntity omsPaymentInfo) {
            omsPaymentInfoService.save(omsPaymentInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
            public R update(@RequestBody OmsPaymentInfoEntity omsPaymentInfo) {
            omsPaymentInfoService.updateById(omsPaymentInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
            public R delete(@RequestBody Long[] ids) {
            omsPaymentInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
