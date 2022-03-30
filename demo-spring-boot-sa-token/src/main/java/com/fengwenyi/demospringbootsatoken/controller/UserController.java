package com.fengwenyi.demospringbootsatoken.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.fengwenyi.api.result.PageRequestVo;
import com.fengwenyi.api.result.ResponseTemplate;
import com.fengwenyi.demospringbootsatoken.data.UserData;
import com.fengwenyi.demospringbootsatoken.vo.request.UserRequestVo;
import com.fengwenyi.demospringbootsatoken.vo.response.UserResponseVo;
import com.fengwenyi.javalib.convert.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-03-30
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @SaCheckRole("ROLE_USER")
    @PostMapping
    public ResponseTemplate<?> add(@RequestBody UserRequestVo requestVo) {
        log.info(JsonUtils.convertString(requestVo));
        return ResponseTemplate.success();
    }

    @SaCheckRole("ROLE_USER")
    @DeleteMapping("/{id}")
    public ResponseTemplate<?> delete(@PathVariable String id) {
        log.info("id={}", id);
        return ResponseTemplate.success();
    }

    @SaCheckRole("ROLE_USER")
    @PutMapping("/{id}")
    public ResponseTemplate<?> update(@PathVariable String id, UserRequestVo requestVo) {
        log.info("id={}, user={}", id, JsonUtils.convertString(requestVo));
        return ResponseTemplate.success();
    }

    @SaCheckRole("ROLE_USER")
    @GetMapping("/{id}")
    public ResponseTemplate<?> get(@PathVariable String id) {
        log.info("id={}", id);
        UserData.User user = UserData.queryByUid(id);
        if (Objects.isNull(user)) {
            return ResponseTemplate.fail("用户不存在");
        }
        UserResponseVo responseVo = new UserResponseVo()
                .setUid(user.uid)
                .setUsername(user.username)
                ;
        return ResponseTemplate.success(responseVo);
    }

    @SaCheckRole("ROLE_USER")
    @GetMapping
    public ResponseTemplate<?> get(PageRequestVo requestVo) {
        log.info(JsonUtils.convertString(requestVo));
        List<UserData.User> users = UserData.queryAll();
        if (CollectionUtils.isEmpty(users)) {
            return ResponseTemplate.success();
        }
        List<UserResponseVo> responseVos = users.stream()
                .map(u ->
                        new UserResponseVo()
                                .setUid(u.uid)
                                .setUsername(u.username)
                )
                .collect(Collectors.toList());
        return ResponseTemplate.success(responseVos);
    }

}
