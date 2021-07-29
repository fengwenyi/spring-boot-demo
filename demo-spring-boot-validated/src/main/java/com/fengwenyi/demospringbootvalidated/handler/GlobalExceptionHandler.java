package com.fengwenyi.demospringbootvalidated.handler;

import com.fengwenyi.api.result.IReturnCode;
import com.fengwenyi.api.result.ResultTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-05-08
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 参数校验异常
     */
    @ExceptionHandler(value = BindException.class)
    public ResultTemplate<Void> BindException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        StringJoiner errorMessage = new StringJoiner(";", "[", "]");
        allErrors.forEach(objectError -> errorMessage.add(objectError.getDefaultMessage()));
        String message = String.format("%s:%s", "参数校验异常", errorMessage);
        return ResultTemplate.fail(IReturnCode.Default.ERROR_PARAM_EXCEPTION.getCode(), message);
    }

    @ExceptionHandler(Exception.class)
    public ResultTemplate<Void> exception(Exception e) {
        e.printStackTrace();
        return ResultTemplate.fail();
    }

}
