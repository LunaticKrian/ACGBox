package wiki.acgcsbox.enums;

/**
 * @author : XiaoBai
 * @apiNote : 异常枚举类
 * @date : 2023/4/4 22:31
 */
public enum ResultCodeEnum {
    /**
     * 处理成功
     */
    OK("200", "处理成功"),
    /**
     * 用户名或密码失败
     */
    FAILURE("201", "用户名或密码失败"),

    REGISTER_FAILED("202", "用户注册失败"),
    /**
     * 请求参数有误
     */
    BAD_REQUEST("400", "请求参数有误"),
    /**
     * 未授权
     */
    UNAUTHORIZED("401", "未授权"),
    TOKEN_ERROR("400", "token不存在或者已经失效!"),
    /**
     * 操作失败
     */
    OPERATION_FAILED("409", "操作失败"),
    /**
     * 商品不存在
     */
    NO_PRODUCT("410", "商品不存在"),
    /**
     * 数据不存在
     */
    NO_DATA("414", "数据不存在"),
    /**
     * 数据已存在
     */
    EXIST_DATA("420", "数据已存在"),

    REPEAT_DATA("421", "请勿重复提交"),
    /**
     * 目标数据异常
     */
    EXCEPTION_DATA("421", "目标数据异常"),
    /**
     * /**
     * 缺少接口中必填参数
     */
    PARAMS_MISS("483", "缺少接口中必填参数"),
    /**
     * 参数非法
     */
    PARAM_ERROR("484", "参数非法"),
    /**
     * 该用户已存在
     */
    FAILED_USER_ALREADY_EXIST("486", "该用户已存在"),
    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR("500", "服务器内部错误"),
    /**
     * 业务异常
     */
    NOT_IMPLEMENTED("490", "添加或者修改失败"),
    /**
     * 授权已过期
     */
    AUTHORIZATION_EXPIRED("499", "授权已过期"),
    ;

    private final String code;
    private final String msg;

    ResultCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
