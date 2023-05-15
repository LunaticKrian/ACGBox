package wiki.acgbox.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import wiki.acgbox.mall.common.utils.PageUtils;
import wiki.acgbox.mall.coupon.entity.SmsHomeSubjectEntity;

import java.util.Map;

/**
 * ��ҳר���jd��ҳ����ܶ�ר�⣬ÿ��ר�������µ�ҳ�棬չʾר����Ʒ��Ϣ��
 *
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 10:20:55
 */
public interface SmsHomeSubjectService extends IService<SmsHomeSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

