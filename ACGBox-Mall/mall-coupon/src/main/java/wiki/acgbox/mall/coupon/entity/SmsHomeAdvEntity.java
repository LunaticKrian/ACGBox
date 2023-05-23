package wiki.acgbox.mall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ��ҳ�ֲ����
 * 
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 10:20:55
 */
@Data
@TableName("sms_home_adv")
public class SmsHomeAdvEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * ����
	 */
	private String name;
	/**
	 * ͼƬ��ַ
	 */
	private String pic;
	/**
	 * ��ʼʱ��
	 */
	private Date startTime;
	/**
	 * ����ʱ��
	 */
	private Date endTime;
	/**
	 * ״̬
	 */
	private Integer status;
	/**
	 * �����
	 */
	private Integer clickCount;
	/**
	 * ����������ӵ�ַ
	 */
	private String url;
	/**
	 * ��ע
	 */
	private String note;
	/**
	 * ����
	 */
	private Integer sort;
	/**
	 * ������
	 */
	private Long publisherId;
	/**
	 * �����
	 */
	private Long authId;

}
