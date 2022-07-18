package com.fengwenyi.demoapiresult;

import com.fengwenyi.api.result.Result;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-07-18
 */
public class ApiResult extends Result.Default {
    /**
     * 构造方法
     *
     * @param code 返回码
     * @param msg  提示信息
     */
    public ApiResult(String code, String msg) {
        super(code, msg);
    }
}
