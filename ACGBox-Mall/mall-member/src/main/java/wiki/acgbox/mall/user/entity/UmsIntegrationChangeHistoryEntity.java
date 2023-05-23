package wiki.acgbox.mall.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ���ֱ仯��ʷ��¼
 * 
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 10:22:04
 */
@Data
@TableName("ums_integration_change_history")
public class UmsIntegrationChangeHistoryEntity implements Serializable {
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
	 * create_time
	 */
	private Date createTime;
	/**
	 * �仯��ֵ
	 */
	private Integer changeCount;
	/**
	 * ��ע
	 */
	private String note;
	/**
	 * ��Դ[0->���1->����Ա�޸�;2->�]
	 */
	private Integer sourceTyoe;

}
