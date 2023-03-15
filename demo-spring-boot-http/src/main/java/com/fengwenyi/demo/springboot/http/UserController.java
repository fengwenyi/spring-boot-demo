package com.fengwenyi.demo.springboot.http;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demo.springboot.http.vo.response.UserResponseVo;
import org.springframework.web.bind.annotation.*;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-03-12
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping("/{userId}")
    public ResultTemplate<UserResponseVo> get(@PathVariable String userId) {
        return ResultTemplate.success();
    }

    @PostMapping
    public ResultTemplate<UserResponseVo> add(@RequestBody UserResponseVo responseVo) {
        return ResultTemplate.success();
    }

    public ResultTemplate<UserResponseVo> update() {
        return ResultTemplate.success();
    }

    @DeleteMapping("/{userId}")
    public ResultTemplate<Void> delete(@PathVariable String userId) {
        return ResultTemplate.success();
    }

    public ResultTemplate<?> uploadAvatar() {
        return ResultTemplate.success();
    }

    public ResultTemplate<?> downloadAvatar() {
        return ResultTemplate.success();
    }

}
