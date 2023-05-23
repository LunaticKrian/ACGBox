package wiki.acgbox.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品分类
 * 
 * @author Krian
 * @email 2793260947@qq.com
 * @date 2023-05-15 09:01:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("pms_category")
public class CategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long catId;

	private String name;

	private Long parentCid;

	private Integer catLevel;

	private Integer showStatus;

	private Integer sort;

	private String icon;

	private String productUnit;

	private Integer productCount;

	@TableField(exist = false)
	private List<CategoryEntity> children;

}
