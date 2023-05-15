package wiki.acgbox.mall.product.controller;

import java.util.Arrays;
import java.util.Map;

        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wiki.acgbox.mall.product.entity.ProductAttrValueEntity;
import wiki.acgbox.mall.product.service.ProductAttrValueService;
import wiki.acgbox.mall.common.utils.PageUtils;
import wiki.acgbox.mall.common.utils.R;


/**
 * spu����ֵ
 *
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 09:01:59
 */
@RestController
@RequestMapping("product/productattrvalue")
public class ProductAttrValueController {
    @Autowired
    private ProductAttrValueService productAttrValueService;

    /**
     * 列表
     */
    @RequestMapping("/list")
            public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = productAttrValueService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
            public R info(@PathVariable("id") Long id) {
            ProductAttrValueEntity productAttrValue = productAttrValueService.getById(id);

        return R.ok().put("productAttrValue", productAttrValue);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
            public R save(@RequestBody ProductAttrValueEntity productAttrValue) {
            productAttrValueService.save(productAttrValue);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
            public R update(@RequestBody ProductAttrValueEntity productAttrValue) {
            productAttrValueService.updateById(productAttrValue);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
            public R delete(@RequestBody Long[] ids) {
            productAttrValueService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
