package wiki.acgbox.mall.user.controller;

import java.util.Arrays;
import java.util.Map;

        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wiki.acgbox.mall.user.entity.UmsMemberReceiveAddressEntity;
import wiki.acgbox.mall.user.service.UmsMemberReceiveAddressService;
import wiki.acgbox.mall.common.utils.PageUtils;
import wiki.acgbox.mall.common.utils.R;


/**
 * ��Ա�ջ���ַ
 *
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 10:22:03
 */
@RestController
@RequestMapping("user/umsmemberreceiveaddress")
public class UmsMemberReceiveAddressController {
    @Autowired
    private UmsMemberReceiveAddressService umsMemberReceiveAddressService;

    /**
     * 列表
     */
    @RequestMapping("/list")
            public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = umsMemberReceiveAddressService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
            public R info(@PathVariable("id") Long id) {
            UmsMemberReceiveAddressEntity umsMemberReceiveAddress = umsMemberReceiveAddressService.getById(id);

        return R.ok().put("umsMemberReceiveAddress", umsMemberReceiveAddress);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
            public R save(@RequestBody UmsMemberReceiveAddressEntity umsMemberReceiveAddress) {
            umsMemberReceiveAddressService.save(umsMemberReceiveAddress);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
            public R update(@RequestBody UmsMemberReceiveAddressEntity umsMemberReceiveAddress) {
            umsMemberReceiveAddressService.updateById(umsMemberReceiveAddress);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
            public R delete(@RequestBody Long[] ids) {
            umsMemberReceiveAddressService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
