package com.fengwenyi.springboot.example.exception;

import com.fengwenyi.springboot.example.enums.ApiResult;

/**
 * 参数异常
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 1.3.1
 */
public class ParamException extends ApiException {

    private static final long serialVersionUID = 475499085988126949L;

    public ParamException() {
    }

    public ParamException(String message) {
        super(message);
        this.setResult(ApiResult.PARAM_EXCEPTION);
    }
}
