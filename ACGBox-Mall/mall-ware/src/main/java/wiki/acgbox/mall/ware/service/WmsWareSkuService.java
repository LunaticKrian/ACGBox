package wiki.acgbox.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import wiki.acgbox.mall.common.utils.PageUtils;
import wiki.acgbox.mall.ware.entity.WmsWareSkuEntity;

import java.util.Map;

/**
 * ��Ʒ���
 *
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 10:23:03
 */
public interface WmsWareSkuService extends IService<WmsWareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

