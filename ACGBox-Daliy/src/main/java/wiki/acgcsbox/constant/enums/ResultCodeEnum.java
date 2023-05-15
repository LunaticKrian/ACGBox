package wiki.acgcsbox.constant.enums;

/**
 * @author Krian
 * @version 1.0
 * @description: TODO
 * @date 2023/4/3 0003 16:26
 */
public enum ResultCodeEnum {
    OK("200", "处理成功"),
    FAILURE("201", "用户名或密码失败"),
    BAD_REQUEST("400", "请求参数有误"),
    UNAUTHORIZED("401", "未授权"),
    TOKEN_ERROR("400", "token不存在或者已经失效!"),
    OPERATION_FAILED("409", "操作失败"),
    NO_DATA("414", "数据不存在"),
    EXIST_DATA("420", "数据已存在"),
    REPEAT_DATA("421", "请勿重复提交"),
    EXCEPTION_DATA("421", "目标数据异常"),
    PARAMS_MISS("483", "缺少接口中必填参数"),
    PARAM_ERROR("484", "参数非法"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误"),
    NOT_IMPLEMENTED("490", "添加或者修改失败"),
    AUTHORIZATION_EXPIRED("499", "授权已过期");

    private String code;
    private String msg;

    private ResultCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
