package wiki.acgbox.mall.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ��������Ϣ
 * 
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 09:31:10
 */
@Data
@TableName("oms_order_item")
public class OmsOrderItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * order_id
	 */
	private Long orderId;
	/**
	 * order_sn
	 */
	private String orderSn;
	/**
	 * spu_id
	 */
	private Long spuId;
	/**
	 * spu_name
	 */
	private String spuName;
	/**
	 * spu_pic
	 */
	private String spuPic;
	/**
	 * Ʒ��
	 */
	private String spuBrand;
	/**
	 * ��Ʒ����id
	 */
	private Long categoryId;
	/**
	 * ��Ʒsku���
	 */
	private Long skuId;
	/**
	 * ��Ʒsku����
	 */
	private String skuName;
	/**
	 * ��ƷskuͼƬ
	 */
	private String skuPic;
	/**
	 * ��Ʒsku�۸�
	 */
	private BigDecimal skuPrice;
	/**
	 * ��Ʒ���������
	 */
	private Integer skuQuantity;
	/**
	 * ��Ʒ����������ϣ�JSON��
	 */
	private String skuAttrsVals;
	/**
	 * ��Ʒ�����ֽ���
	 */
	private BigDecimal promotionAmount;
	/**
	 * �Ż�ȯ�Żݷֽ���
	 */
	private BigDecimal couponAmount;
	/**
	 * �����Żݷֽ���
	 */
	private BigDecimal integrationAmount;
	/**
	 * ����Ʒ�����Żݺ�ķֽ���
	 */
	private BigDecimal realAmount;
	/**
	 * ���ͻ���
	 */
	private Integer giftIntegration;
	/**
	 * ���ͳɳ�ֵ
	 */
	private Integer giftGrowth;

}
