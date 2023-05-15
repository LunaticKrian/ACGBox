package wiki.acgbox.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import wiki.acgbox.mall.common.utils.PageUtils;
import wiki.acgbox.mall.product.entity.SkuImagesEntity;

import java.util.Map;

/**
 * skuͼƬ
 *
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 09:01:58
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

