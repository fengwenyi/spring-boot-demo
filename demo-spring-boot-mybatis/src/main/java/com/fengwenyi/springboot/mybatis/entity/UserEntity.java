package com.fengwenyi.springboot.mybatis.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-10-24
 */
@Data
@Accessors(chain = true)
public class UserEntity {

    private Integer id;
    private String name;
    private Integer age;

}
