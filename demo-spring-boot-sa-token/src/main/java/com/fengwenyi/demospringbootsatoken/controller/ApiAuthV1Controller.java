package com.fengwenyi.demospringbootsatoken.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demospringbootsatoken.domain.UserModel;
import com.fengwenyi.demospringbootsatoken.vo.LoginRequestVo;
import com.fengwenyi.demospringbootsatoken.vo.LoginResponseVo;
import com.fengwenyi.javalib.generate.IdUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-05-10
 */
@RestController
@RequestMapping("/api/auth/v1")
public class ApiAuthV1Controller {

    final Map<String, UserModel> userMap = new ConcurrentHashMap<>();

    @PostMapping("/login")
    public ResultTemplate<?> login(@RequestBody LoginRequestVo requestVo) {
        String username = requestVo.getUsername();
        String password = requestVo.getPassword();

        UserModel userModel = userMap.get(username);
        if (userModel == null) {
            userModel = new UserModel()
                    .setUid(IdUtils.getIdByUUID())
                    .setUsername(username)
                    .setPassword(password)
                    ;
            userMap.put(username, userModel);
        } else {
            if (!password.equals(userModel.getPassword())) {
                return ResultTemplate.fail("密码不正确");
            }
        }
        StpUtil.setLoginId(userModel.getUid());
        LoginResponseVo responseVo = new LoginResponseVo().setToken(StpUtil.getTokenValue());
        return ResultTemplate.success(responseVo);
    }

}
