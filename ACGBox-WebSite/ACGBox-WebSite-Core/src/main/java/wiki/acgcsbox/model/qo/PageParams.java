package wiki.acgcsbox.model.qo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * @author Krian
 * @version 1.0
 * @description: 分页查询条件参数封装类
 * @date 2023/3/17 0017 14:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)  // 允许链式调用
public class PageParams {

    // 当前记录页码：
    @NotNull
    private Long pageNo;

    // 每页显示记录数：
    @NotNull
    private Long pageSize;
}
