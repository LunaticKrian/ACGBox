package wiki.acgcsbox.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;

/**
 * @author : XiaoBai
 * @apiNote :菜单分类表
 * @date : 2023/4/4 21:26
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("acgbox_user_menu_classify")
public class MenuClassify extends BasePo{

    /**
     * 分类名称
     */
    @Column(name = "classify_name")
    private String classifyName;

    /**
     * 分类类型
     */
    @Column(name = "classify_type")
    private Integer classifyType;
}
