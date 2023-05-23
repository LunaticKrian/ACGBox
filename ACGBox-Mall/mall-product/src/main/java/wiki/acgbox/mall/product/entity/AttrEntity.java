package wiki.acgbox.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ��Ʒ����
 * 
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 09:01:59
 */
@Data
@TableName("pms_attr")
public class AttrEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ����id
	 */
	@TableId
	private Long attrId;
	/**
	 * ������
	 */
	private String attrName;
	/**
	 * �Ƿ���Ҫ����[0-����Ҫ��1-��Ҫ]
	 */
	private Integer searchType;
	/**
	 * ����ͼ��
	 */
	private String icon;
	/**
	 * ��ѡֵ�б�[�ö��ŷָ�]
	 */
	private String valueSelect;
	/**
	 * ��������[0-�������ԣ�1-�������ԣ�2-���������������ǻ�������]
	 */
	private Integer attrType;
	/**
	 * ����״̬[0 - ���ã�1 - ����]
	 */
	private Long enable;
	/**
	 * ��������
	 */
	private Long catelogId;
	/**
	 * ����չʾ���Ƿ�չʾ�ڽ����ϣ�0-�� 1-�ǡ�����sku����Ȼ���Ե���
	 */
	private Integer showDesc;

}
