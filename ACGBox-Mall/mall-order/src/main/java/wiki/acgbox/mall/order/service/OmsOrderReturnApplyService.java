package wiki.acgbox.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import wiki.acgbox.mall.common.utils.PageUtils;
import wiki.acgbox.mall.order.entity.OmsOrderReturnApplyEntity;

import java.util.Map;

/**
 * �����˻�����
 *
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 09:31:09
 */
public interface OmsOrderReturnApplyService extends IService<OmsOrderReturnApplyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

