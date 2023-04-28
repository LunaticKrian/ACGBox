package wiki.acgcsbox.constant;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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

    // 默认起始页码
    public static final long DEFAULT_PAGE_CURRENT = 1L;
    // 默认每页记录数
    public static final long DEFAULT_PAGE_SIZE = 10L;

    // 当前页码
    @ApiModelProperty(value = "当前页码", example = "1")
    private Long pageNo = DEFAULT_PAGE_CURRENT;

    // 当前每页记录数
    @ApiModelProperty(value = "每页记录数", example = "2")
    private Long pageSize = DEFAULT_PAGE_SIZE;
}
