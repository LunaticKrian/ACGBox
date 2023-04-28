package wiki.acgcsbox.constant;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Krian
 * @version 1.0
 * @description: 统一响应结果封装类
 * @date 2023/4/3 0003 16:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("请求是否成功")
    private boolean success;

    @ApiModelProperty("响应状态码")
    private int code;

    @ApiModelProperty("响应信息")
    private String msg;

    @ApiModelProperty("错误提示信息")
    private String errorMsg;

    @ApiModelProperty("响应数据")
    private T data;

}
