package wiki.acgbox.mall.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import wiki.acgbox.mall.common.utils.PageUtils;
import wiki.acgbox.mall.common.utils.Query;

import wiki.acgbox.mall.ware.dao.WmsWareOrderTaskDetailDao;
import wiki.acgbox.mall.ware.entity.WmsWareOrderTaskDetailEntity;
import wiki.acgbox.mall.ware.service.WmsWareOrderTaskDetailService;


@Service("wmsWareOrderTaskDetailService")
public class WmsWareOrderTaskDetailServiceImpl extends ServiceImpl<WmsWareOrderTaskDetailDao, WmsWareOrderTaskDetailEntity> implements WmsWareOrderTaskDetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WmsWareOrderTaskDetailEntity> page = this.page(
                new Query<WmsWareOrderTaskDetailEntity>().getPage(params),
                new QueryWrapper<WmsWareOrderTaskDetailEntity>()
        );

        return new PageUtils(page);
    }

}