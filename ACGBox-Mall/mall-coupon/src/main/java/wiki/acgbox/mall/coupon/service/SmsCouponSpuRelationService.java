package wiki.acgbox.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import wiki.acgbox.mall.common.utils.PageUtils;
import wiki.acgbox.mall.coupon.entity.SmsCouponSpuRelationEntity;

import java.util.Map;

/**
 * �Ż�ȯ���Ʒ����
 *
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 10:20:55
 */
public interface SmsCouponSpuRelationService extends IService<SmsCouponSpuRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

