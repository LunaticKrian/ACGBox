package wiki.acgbox.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import wiki.acgbox.mall.common.utils.PageUtils;
import wiki.acgbox.mall.order.entity.OmsOrderItemEntity;

import java.util.Map;

/**
 * ��������Ϣ
 *
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 09:31:10
 */
public interface OmsOrderItemService extends IService<OmsOrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

