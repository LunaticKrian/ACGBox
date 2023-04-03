package wiki.acgcsbox.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import wiki.acgcsbox.constent.Result;
import wiki.acgcsbox.model.dto.WebsiteMenuDto;
import wiki.acgcsbox.model.po.WebsiteMenu;
import wiki.acgcsbox.mapper.WebsiteMenuMapper;
import wiki.acgcsbox.service.WebsiteMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 网站导航站点分类菜单表 服务实现类
 * </p>
 *
 * @author Krian
 */
@Slf4j
@Service
public class WebsiteMenuServiceImpl extends ServiceImpl<WebsiteMenuMapper, WebsiteMenu> implements WebsiteMenuService {

    @Autowired
    private WebsiteMenuMapper websiteMenuMapper;

    public Result<WebsiteMenuDto> add(WebsiteMenuDto websiteMenuDto) {
        // 先判断是否已经创建了相同名字的分类菜单：

        // 向数据库拆入数据：
        int flag = websiteMenuMapper.insert(websiteMenuDto);
        if (flag <= 0) {
            return new Result<WebsiteMenuDto>().setCode("500").setErrorMsg("数据写入数据库失败！");
        }
        return new Result<>();
    }
}
