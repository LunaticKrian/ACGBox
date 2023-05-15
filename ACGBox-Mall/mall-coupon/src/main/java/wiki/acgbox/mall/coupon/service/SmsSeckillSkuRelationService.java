package wiki.acgbox.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import wiki.acgbox.mall.common.utils.PageUtils;
import wiki.acgbox.mall.coupon.entity.SmsSeckillSkuRelationEntity;

import java.util.Map;

/**
 * ��ɱ���Ʒ����
 *
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 10:20:55
 */
public interface SmsSeckillSkuRelationService extends IService<SmsSeckillSkuRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

