package wiki.acgbox.mall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ��ɱ�����
 * 
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 10:20:55
 */
@Data
@TableName("sms_seckill_session")
public class SmsSeckillSessionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * ��������
	 */
	private String name;
	/**
	 * ÿ�տ�ʼʱ��
	 */
	private Date startTime;
	/**
	 * ÿ�ս���ʱ��
	 */
	private Date endTime;
	/**
	 * ����״̬
	 */
	private Integer status;
	/**
	 * ����ʱ��
	 */
	private Date createTime;

}
