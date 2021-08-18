package com.fengwenyi.demospringbootwebflux.controller;

import com.fengwenyi.api.result.ResultTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-18
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{userId}")
    public Mono<ResultTemplate<?>> getUser(@PathVariable Long userId) {
        return Mono.just(ResultTemplate.success(userId));
    }

}
