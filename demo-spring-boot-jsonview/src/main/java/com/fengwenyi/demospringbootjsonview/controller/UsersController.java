package com.fengwenyi.demospringbootjsonview.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fengwenyi.api.result.ResponseTemplate;
import com.fengwenyi.demospringbootjsonview.view.UserView;
import com.fengwenyi.demospringbootjsonview.vo.response.UserResponseVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-02-08
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    public void test() {
        /*
        Feature that determines whether properties that have no view annotations are included in JSON serialization views (see com.fasterxml.jackson.annotation.JsonView for more details on JSON Views). If enabled, non-annotated properties will be included; when disabled, they will be excluded. So this feature changes between "opt-in" (feature disabled) and "opt-out" (feature enabled) modes.
Default value is enabled, meaning that non-annotated properties are included in all views if there is no com.fasterxml.jackson.annotation.JsonView annotation.
Feature is enabled by default.
         */
//    MapperFeature.DEFAULT_VIEW_INCLUSION;

        ObjectMapper om = new ObjectMapper().disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
        JsonMapper.builder().disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
    }

    private static final List<UserResponseVo> users = List.of(
            new UserResponseVo().setId(1).setUsername("u1").setPassword("123456").setAge(21),
            new UserResponseVo().setId(2).setUsername("u2").setPassword("123456").setAge(22),
            new UserResponseVo().setId(3).setUsername("u3").setPassword("123456").setAge(23)
    );

    @GetMapping
    @JsonView(UserView.UserList.class)
    public ResponseTemplate<List<UserResponseVo>> users() {
        return ResponseTemplate.success(users);
    }
    /*public List<UserResponseVo> users() {
        return users;
    }*/

    @GetMapping("/{id}")
    @JsonView(UserView.UserDetail.class)
    public ResponseTemplate<UserResponseVo> user(@PathVariable Integer id) {
        return ResponseTemplate.success(users.get(id - 1));
    }

}
