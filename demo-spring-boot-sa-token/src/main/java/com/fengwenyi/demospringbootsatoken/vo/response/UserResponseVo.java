package com.fengwenyi.demospringbootsatoken.vo.response;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-03-30
 */
@Data
@Accessors(chain = true)
public class UserResponseVo {

    public String uid;
    public String username;
}
