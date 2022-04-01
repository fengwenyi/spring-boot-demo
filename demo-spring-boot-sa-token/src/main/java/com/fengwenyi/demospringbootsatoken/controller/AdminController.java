package com.fengwenyi.demospringbootsatoken.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-04-01
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @SaCheckRole("ROLE_ADMIN")
    @GetMapping
    public String get() {
        return "admin get";
    }
}
