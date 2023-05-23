package wiki.acgbox.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * spuͼƬ
 * 
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 09:01:58
 */
@Data
@TableName("pms_spu_images")
public class SpuImagesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * spu_id
	 */
	private Long spuId;
	/**
	 * ͼƬ��
	 */
	private String imgName;
	/**
	 * ͼƬ��ַ
	 */
	private String imgUrl;
	/**
	 * ˳��
	 */
	private Integer imgSort;
	/**
	 * �Ƿ�Ĭ��ͼ
	 */
	private Integer defaultImg;

}
