package com.fengwenyi.demospringbootsatoken.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-05-10
 */
@Data
@Accessors(chain = true)
public class UserModel {

    private String uid;

    private String username;

    private String password;

    private String nickname;

}
