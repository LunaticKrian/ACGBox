package wiki.acgbox.mall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ��ɱ��Ʒ֪ͨ����
 * 
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 10:20:55
 */
@Data
@TableName("sms_seckill_sku_notice")
public class SmsSeckillSkuNoticeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * member_id
	 */
	private Long memberId;
	/**
	 * sku_id
	 */
	private Long skuId;
	/**
	 * �����id
	 */
	private Long sessionId;
	/**
	 * ����ʱ��
	 */
	private Date subcribeTime;
	/**
	 * ����ʱ��
	 */
	private Date sendTime;
	/**
	 * ֪ͨ��ʽ[0-���ţ�1-�ʼ�]
	 */
	private Integer noticeType;

}
