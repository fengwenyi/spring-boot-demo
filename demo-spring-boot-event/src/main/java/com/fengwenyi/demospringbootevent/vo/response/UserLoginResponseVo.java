package com.fengwenyi.demospringbootevent.vo.response;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-18
 */
@Data
@Accessors(chain = true)
public class UserLoginResponseVo {

    private String token;

}
