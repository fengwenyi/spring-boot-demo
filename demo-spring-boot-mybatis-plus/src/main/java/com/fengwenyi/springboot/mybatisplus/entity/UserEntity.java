package com.fengwenyi.springboot.mybatisplus.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-25
 */
@Data
@Accessors(chain = true)
public class UserEntity {

    private Integer id;
    private String name;
    private Integer age;

}
