package com.fengwenyi.demoapiresult;

import com.fengwenyi.api.result.Result;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-06-18
 */
public enum ResultEnum implements Result {

    USERNAME_NOT_EXIST("USERNAME_NOT_EXIST", "用户名不存在"),
    PASSWORD_INCORRECT("PASSWORD_INCORRECT", "密码不正确")

    ;

    private final String code;

    private final String msg;

    ResultEnum(String code, String msg) {
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
