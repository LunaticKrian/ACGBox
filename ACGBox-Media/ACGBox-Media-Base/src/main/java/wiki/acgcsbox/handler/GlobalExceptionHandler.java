package wiki.acgcsbox.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import wiki.acgcsbox.constant.enums.CommonError;
import wiki.acgcsbox.exception.ACGCSBoxException;
import wiki.acgcsbox.exception.RestErrorResponse;

import java.util.List;

/**
 * @author Krian
 * @version 1.0
 * @description: 异常信息处理器
 * @date 2023/3/20 0020 18:05
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 自定义异常信息处理
     *
     * @param exception 异常
     * @return RestErrorResponse
     */
    @ExceptionHandler(ACGCSBoxException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestErrorResponse customerException(ACGCSBoxException exception) {
        // 日志输出异常信息：
        log.error("系统异常：{}", exception.getErrMessage(), exception);

        // 解析出异常信息：
        String errMessage = exception.getErrMessage();
        return new RestErrorResponse(errMessage);
    }

    /**
     * JSR 303 参数校验异常处理器
     *
     * @param exception 异常
     * @return RestErrorResponse
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)  // 此方法捕获MethodArgumentNotValidException异常
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  // 状态码返回500
    public RestErrorResponse doMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

        BindingResult bindingResult = exception.getBindingResult();
        // 校验的错误信息
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        // 收集错误
        StringBuffer errors = new StringBuffer();
        fieldErrors.forEach(error -> {
            errors.append(error.getDefaultMessage()).append(",");
        });

        return new RestErrorResponse(errors.toString());
    }

    /**
     * 通用异常信息处理
     *
     * @param exception 异常
     * @return RestErrorResponse
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestErrorResponse exception(Exception exception) {
        // 日志输出异常信息：
        log.error("系统异常：{}", exception.getMessage(), exception);

        // 解析出异常信息：
        return new RestErrorResponse(CommonError.UNKNOWN_ERROR.getErrMessage());
    }

}
