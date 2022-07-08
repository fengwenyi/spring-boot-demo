package com.fengwenyi.springboot.example.exception;

import com.fengwenyi.api.result.Result;
import lombok.Getter;
import lombok.Setter;

/**
 * API Exception
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-11
 */
@Getter
@Setter
public class ApiException extends RuntimeException {

    private static final long serialVersionUID = -5829546532420722185L;

    private Result result;

    public ApiException() {
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Result result) {
        this.result = result;
    }

    public ApiException(Result result, String message) {
        super(message);
        this.result = result;
    }

    public ApiException(Result result, Throwable cause) {
        super(cause);
        this.result = result;
    }

    public ApiException(Result result, Throwable cause, String message) {
        super(message, cause);
        this.result = result;
    }
}

