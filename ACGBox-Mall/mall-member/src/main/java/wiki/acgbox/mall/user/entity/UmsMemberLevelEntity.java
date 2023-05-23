package wiki.acgbox.mall.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ��Ա�ȼ�
 * 
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 10:22:03
 */
@Data
@TableName("ums_member_level")
public class UmsMemberLevelEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * �ȼ�����
	 */
	private String name;
	/**
	 * �ȼ���Ҫ�ĳɳ�ֵ
	 */
	private Integer growthPoint;
	/**
	 * �Ƿ�ΪĬ�ϵȼ�[0->���ǣ�1->��]
	 */
	private Integer defaultStatus;
	/**
	 * ���˷ѱ�׼
	 */
	private BigDecimal freeFreightPoint;
	/**
	 * ÿ�����ۻ�ȡ�ĳɳ�ֵ
	 */
	private Integer commentGrowthPoint;
	/**
	 * �Ƿ���������Ȩ
	 */
	private Integer priviledgeFreeFreight;
	/**
	 * �Ƿ��л�Ա�۸���Ȩ
	 */
	private Integer priviledgeMemberPrice;
	/**
	 * �Ƿ���������Ȩ
	 */
	private Integer priviledgeBirthday;
	/**
	 * ��ע
	 */
	private String note;

}
