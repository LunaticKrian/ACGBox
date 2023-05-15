package wiki.acgbox.mall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ��Ʒ���
 * 
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 10:23:03
 */
@Data
@TableName("wms_ware_sku")
public class WmsWareSkuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * sku_id
	 */
	private Long skuId;
	/**
	 * �ֿ�id
	 */
	private Long wareId;
	/**
	 * �����
	 */
	private Integer stock;
	/**
	 * sku_name
	 */
	private String skuName;
	/**
	 * �������
	 */
	private Integer stockLocked;

}
