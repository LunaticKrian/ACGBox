package wiki.acgbox.mall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ��ҳר���jd��ҳ����ܶ�ר�⣬ÿ��ר�������µ�ҳ�棬չʾר����Ʒ��Ϣ��
 * 
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 10:20:55
 */
@Data
@TableName("sms_home_subject")
public class SmsHomeSubjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * ר������
	 */
	private String name;
	/**
	 * ר�����
	 */
	private String title;
	/**
	 * ר�⸱����
	 */
	private String subTitle;
	/**
	 * ��ʾ״̬
	 */
	private Integer status;
	/**
	 * ��������
	 */
	private String url;
	/**
	 * ����
	 */
	private Integer sort;
	/**
	 * ר��ͼƬ��ַ
	 */
	private String img;

}
