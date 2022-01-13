package com.fengwenyi.demospringbootsatoken;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import com.fengwenyi.api.result.ResponseTemplate;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-01-13
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(NotLoginException.class)
    public ResponseTemplate<Void> notLogin() {
        return ResponseTemplate.fail("未登录");
    }

    @ExceptionHandler(NotPermissionException.class)
    public ResponseTemplate<Void> notPermission() {
        return ResponseTemplate.fail("无权限");
    }

    @ExceptionHandler(NotRoleException.class)
    public ResponseTemplate<Void> notRole() {
        return ResponseTemplate.fail("无角色");
    }

}
