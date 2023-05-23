package wiki.acgbox.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import wiki.acgbox.mall.common.utils.PageUtils;
import wiki.acgbox.mall.ware.entity.WmsWareOrderTaskDetailEntity;

import java.util.Map;

/**
 * ��湤����
 *
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 10:23:04
 */
public interface WmsWareOrderTaskDetailService extends IService<WmsWareOrderTaskDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

