package wiki.acgbox.mall.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import wiki.acgbox.mall.common.utils.PageUtils;
import wiki.acgbox.mall.user.entity.UmsMemberReceiveAddressEntity;

import java.util.Map;

/**
 * ��Ա�ջ���ַ
 *
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 10:22:03
 */
public interface UmsMemberReceiveAddressService extends IService<UmsMemberReceiveAddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

