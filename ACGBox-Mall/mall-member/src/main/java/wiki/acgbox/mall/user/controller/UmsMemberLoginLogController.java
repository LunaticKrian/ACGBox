package wiki.acgbox.mall.user.controller;

import java.util.Arrays;
import java.util.Map;

        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wiki.acgbox.mall.user.entity.UmsMemberLoginLogEntity;
import wiki.acgbox.mall.user.service.UmsMemberLoginLogService;
import wiki.acgbox.mall.common.utils.PageUtils;
import wiki.acgbox.mall.common.utils.R;


/**
 * ��Ա��¼��¼
 *
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 10:22:03
 */
@RestController
@RequestMapping("user/umsmemberloginlog")
public class UmsMemberLoginLogController {
    @Autowired
    private UmsMemberLoginLogService umsMemberLoginLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
            public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = umsMemberLoginLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
            public R info(@PathVariable("id") Long id) {
            UmsMemberLoginLogEntity umsMemberLoginLog = umsMemberLoginLogService.getById(id);

        return R.ok().put("umsMemberLoginLog", umsMemberLoginLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
            public R save(@RequestBody UmsMemberLoginLogEntity umsMemberLoginLog) {
            umsMemberLoginLogService.save(umsMemberLoginLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
            public R update(@RequestBody UmsMemberLoginLogEntity umsMemberLoginLog) {
            umsMemberLoginLogService.updateById(umsMemberLoginLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
            public R delete(@RequestBody Long[] ids) {
            umsMemberLoginLogService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
