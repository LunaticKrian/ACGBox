package wiki.acgbox.mall.order.controller;

import java.util.Arrays;
import java.util.Map;

        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wiki.acgbox.mall.order.entity.OmsOrderItemEntity;
import wiki.acgbox.mall.order.service.OmsOrderItemService;
import wiki.acgbox.mall.common.utils.PageUtils;
import wiki.acgbox.mall.common.utils.R;


/**
 * ��������Ϣ
 *
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 09:31:10
 */
@RestController
@RequestMapping("order/omsorderitem")
public class OmsOrderItemController {
    @Autowired
    private OmsOrderItemService omsOrderItemService;

    /**
     * 列表
     */
    @RequestMapping("/list")
            public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = omsOrderItemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
            public R info(@PathVariable("id") Long id) {
            OmsOrderItemEntity omsOrderItem = omsOrderItemService.getById(id);

        return R.ok().put("omsOrderItem", omsOrderItem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
            public R save(@RequestBody OmsOrderItemEntity omsOrderItem) {
            omsOrderItemService.save(omsOrderItem);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
            public R update(@RequestBody OmsOrderItemEntity omsOrderItem) {
            omsOrderItemService.updateById(omsOrderItem);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
            public R delete(@RequestBody Long[] ids) {
            omsOrderItemService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
