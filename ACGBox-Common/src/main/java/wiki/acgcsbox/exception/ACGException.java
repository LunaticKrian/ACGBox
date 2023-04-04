package wiki.acgcsbox.exception;

import wiki.acgcsbox.enums.ResultCodeEnum;

/**
 * @author : XiaoBai
 * @apiNote :
 * @date : 2023/4/4 22:33
 */
public class ACGException  extends RuntimeException{
    private String code;

    private String msg;

    public ACGException(String msg) {
        super(msg);
    }

    public ACGException(ResultCodeEnum resultCodeEnum) {
        this(resultCodeEnum.getCode(), resultCodeEnum.getMsg());
    }

    public ACGException(ResultCodeEnum resultCodeEnum, String msg) {
        super(msg);
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getCode();
    }

    public ACGException(Integer code, String msg) {
        super(msg);
        this.code = code.toString();
        this.msg = msg;
    }

    public ACGException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
