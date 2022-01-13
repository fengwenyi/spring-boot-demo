package com.fengwenyi.demospringbootsatoken.vo.response;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-05-10
 */
@Data
@Accessors(chain = true)
public class LoginResponseVo {

    private String token;

}
