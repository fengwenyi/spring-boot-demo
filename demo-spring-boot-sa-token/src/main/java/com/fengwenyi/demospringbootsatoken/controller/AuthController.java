package com.fengwenyi.demospringbootsatoken.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.fengwenyi.api.result.ResponseTemplate;
import com.fengwenyi.demospringbootsatoken.data.UserData;
import com.fengwenyi.demospringbootsatoken.vo.request.LoginRequestVo;
import com.fengwenyi.demospringbootsatoken.vo.response.LoginResponseVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-05-10
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseTemplate<LoginResponseVo> login(@RequestBody @Validated LoginRequestVo requestVo) {
        String username = requestVo.getUsername();
        String password = requestVo.getPassword();

        UserData.User user = UserData.queryByUsername(username);

        if (Objects.isNull(user)) {
            return ResponseTemplate.fail("用户名不正确");
        }

        if (!user.password.equals(password)) {
            return ResponseTemplate.fail("密码不正确");
        }

        StpUtil.login(user.uid);
        LoginResponseVo responseVo = new LoginResponseVo()
                .setToken(StpUtil.getTokenValue())
                ;
        return ResponseTemplate.success(responseVo);
    }

    @PostMapping("/logout")
    public ResponseTemplate<Void> logout() {
        StpUtil.logout();
        return ResponseTemplate.success();
    }

}
