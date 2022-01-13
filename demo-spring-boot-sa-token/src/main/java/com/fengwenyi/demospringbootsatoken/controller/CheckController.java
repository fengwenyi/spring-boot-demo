package com.fengwenyi.demospringbootsatoken.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaCheckRole;
import com.fengwenyi.api.result.ResponseTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-01-13
 */
@RestController
@RequestMapping("/check")
public class CheckController {

    @GetMapping("/role")
    @SaCheckRole("ROLE_USER")
    public ResponseTemplate<?> role() {
        return ResponseTemplate.success();
    }

    @GetMapping("/permission")
    @SaCheckPermission("ADD")
    public ResponseTemplate<?> permission() {
        return ResponseTemplate.success();
    }

    @GetMapping("/login")
    @SaCheckLogin
    public ResponseTemplate<?> login() {
        return ResponseTemplate.success();
    }

}
