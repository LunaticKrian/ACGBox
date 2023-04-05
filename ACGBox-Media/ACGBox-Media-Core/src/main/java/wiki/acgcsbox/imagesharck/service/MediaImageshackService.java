package wiki.acgcsbox.imagesharck.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import wiki.acgcsbox.imagesharck.model.dto.MediaImageshackDto;
import wiki.acgcsbox.imagesharck.model.po.MediaImageshack;

/**
 * <p>
 * 图床记录表 服务类
 * </p>
 *
 * @author Krian
 * @since 2023-04-05
 */
@Service
public interface MediaImageshackService extends IService<MediaImageshack> {

    MediaImageshackDto upload(String localFilePath, MediaImageshackDto mediaImageshackDto);
}
