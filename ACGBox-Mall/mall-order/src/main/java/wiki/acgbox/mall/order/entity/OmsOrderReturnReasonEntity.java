package wiki.acgbox.mall.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * �˻�ԭ��
 * 
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 09:31:10
 */
@Data
@TableName("oms_order_return_reason")
public class OmsOrderReturnReasonEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * �˻�ԭ����
	 */
	private String name;
	/**
	 * ����
	 */
	private Integer sort;
	/**
	 * ����״̬
	 */
	private Integer status;
	/**
	 * create_time
	 */
	private Date createTime;

}
