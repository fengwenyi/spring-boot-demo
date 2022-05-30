package com.fengwenyi.springboot.jpa.example.vo.request;

import lombok.Data;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-05-30
 */
@Data
public class LoginRequestVo {

    private String username;

    private String password;

}
