package wiki.acgbox.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ���Է���
 * 
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 09:01:59
 */
@Data
@TableName("pms_attr_group")
public class AttrGroupEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ����id
	 */
	@TableId
	private Long attrGroupId;
	/**
	 * ����
	 */
	private String attrGroupName;
	/**
	 * ����
	 */
	private Integer sort;
	/**
	 * ����
	 */
	private String descript;
	/**
	 * ��ͼ��
	 */
	private String icon;
	/**
	 * ��������id
	 */
	private Long catelogId;

}
