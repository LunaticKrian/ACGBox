package wiki.acgcsbox.service.impl;

import wiki.acgcsbox.model.po.AcgboxWebsiteSite;
import wiki.acgcsbox.mapper.AcgboxWebsiteSiteMapper;
import wiki.acgcsbox.service.AcgboxWebsiteSiteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 网站导航网站记录表 服务实现类
 * </p>
 *
 * @author Krian
 */
@Slf4j
@Service
public class AcgboxWebsiteSiteServiceImpl extends ServiceImpl<AcgboxWebsiteSiteMapper, AcgboxWebsiteSite> implements AcgboxWebsiteSiteService {

}
