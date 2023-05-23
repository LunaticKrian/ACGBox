package wiki.acgbox.mall.ware.controller;

import java.util.Arrays;
import java.util.Map;

        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wiki.acgbox.mall.ware.entity.WmsWareOrderTaskDetailEntity;
import wiki.acgbox.mall.ware.service.WmsWareOrderTaskDetailService;
import wiki.acgbox.mall.common.utils.PageUtils;
import wiki.acgbox.mall.common.utils.R;


/**
 * ��湤����
 *
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 10:23:04
 */
@RestController
@RequestMapping("ware/wmswareordertaskdetail")
public class WmsWareOrderTaskDetailController {
    @Autowired
    private WmsWareOrderTaskDetailService wmsWareOrderTaskDetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
            public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = wmsWareOrderTaskDetailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
            public R info(@PathVariable("id") Long id) {
            WmsWareOrderTaskDetailEntity wmsWareOrderTaskDetail = wmsWareOrderTaskDetailService.getById(id);

        return R.ok().put("wmsWareOrderTaskDetail", wmsWareOrderTaskDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
            public R save(@RequestBody WmsWareOrderTaskDetailEntity wmsWareOrderTaskDetail) {
            wmsWareOrderTaskDetailService.save(wmsWareOrderTaskDetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
            public R update(@RequestBody WmsWareOrderTaskDetailEntity wmsWareOrderTaskDetail) {
            wmsWareOrderTaskDetailService.updateById(wmsWareOrderTaskDetail);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
            public R delete(@RequestBody Long[] ids) {
            wmsWareOrderTaskDetailService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
