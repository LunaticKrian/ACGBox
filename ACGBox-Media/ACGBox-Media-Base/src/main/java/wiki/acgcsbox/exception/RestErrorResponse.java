package wiki.acgcsbox.exception;

import java.io.Serializable;

/**
 * @author Krian
 * @version 1.0
 * @description: TODO 错误响应参数包装类（全局异常信息响应类）
 * @date 2023/3/20 0020 17:42
 */
public class RestErrorResponse implements Serializable {

    private String errMessage;

    public RestErrorResponse(String errMessage) {
        this.errMessage = errMessage;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
