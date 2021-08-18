package com.fengwenyi.demospringbootevent.vo.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-18
 */
@Data
@Accessors(chain = true)
public class UserLoginRequestVo {

    private String username;

    private String password;

}
