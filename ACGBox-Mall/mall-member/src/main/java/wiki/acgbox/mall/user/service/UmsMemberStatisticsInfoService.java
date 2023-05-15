package wiki.acgbox.mall.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import wiki.acgbox.mall.common.utils.PageUtils;
import wiki.acgbox.mall.user.entity.UmsMemberStatisticsInfoEntity;

import java.util.Map;

/**
 * ��Աͳ����Ϣ
 *
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 10:22:03
 */
public interface UmsMemberStatisticsInfoService extends IService<UmsMemberStatisticsInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

