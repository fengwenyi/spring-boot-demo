package com.fengwenyi.demospringbootredis.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-08-15
 */
@Data
@Accessors(chain = true)
public class UserModel {

    private String uid;
    private String name;
    private Integer age;

}
