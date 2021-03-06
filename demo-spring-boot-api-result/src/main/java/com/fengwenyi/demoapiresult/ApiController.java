package com.fengwenyi.demoapiresult;

import com.fengwenyi.api.result.PageTemplate;
import com.fengwenyi.api.result.ResultTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-10-24
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @RequestMapping("/demo")
    public ResultTemplate<Void> demo() {
        return ResultTemplate.success();
    }

    @RequestMapping("/err-msg")
    public ResultTemplate<Void> errMsg() {
        return ResultTemplate.fail("test error!");
    }

    @RequestMapping("/page-response")
    public ResultTemplate<PageTemplate<String>> pageResponse() {

        List<String> list = Arrays.asList("u1", "u2", "u3");

        PageTemplate<String> pageTemplate = new PageTemplate.Builder<String>()
                .current(1)
                .pageSize(10)
                .totalPage(1)
                .totalRow(list.size())
                .content(list)
                .build();


        return ResultTemplate.success(pageTemplate);
    }

    @PostMapping("/login")
    public ResultTemplate<String> login(String username, String password) {
        if (!"zhangsan".equals(username)) {
            return ResultTemplate.fail(ResultEnum.USERNAME_NOT_EXIST);
        }
        if (!"123456".equals(password)) {
            return ResultTemplate.fail(ResultEnum.PASSWORD_INCORRECT);
        }
        return ResultTemplate.success(UUID.randomUUID().toString());
    }
}
