package com.fengwenyi.springboot.example.enums;

import com.fengwenyi.api.result.Result;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-06-09
 */
public class ApiResult implements Result {

    public static final Result PARAM_EXCEPTION = new ApiResult("PARAM_EXCEPTION", "参数异常");
    public static final Result PARAM_ILLEGAL = new ApiResult("PARAM_ILLEGAL", "参数非法");
    public static final Result PARAM_MISS = new ApiResult("PARAM_MISS", "参数缺失");
    public static final Result PARAM_VALIDATION_FAILED = new ApiResult("PARAM_VALIDATION_FAILED", "参数校验失败");

    public static final Result DATA_EXCEPTION = new ApiResult("DATA_EXCEPTION", "数据异常");



    private final String code;

    private final String msg;

    ApiResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }


}
