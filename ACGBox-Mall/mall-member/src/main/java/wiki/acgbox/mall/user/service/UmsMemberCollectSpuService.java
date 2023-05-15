package wiki.acgbox.mall.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import wiki.acgbox.mall.common.utils.PageUtils;
import wiki.acgbox.mall.user.entity.UmsMemberCollectSpuEntity;

import java.util.Map;

/**
 * ��Ա�ղص���Ʒ
 *
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 10:22:03
 */
public interface UmsMemberCollectSpuService extends IService<UmsMemberCollectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

