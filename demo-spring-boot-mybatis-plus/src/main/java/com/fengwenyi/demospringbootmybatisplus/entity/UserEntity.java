package com.fengwenyi.demospringbootmybatisplus.entity;

import com.fengwenyi.demospringbootmybatisplus.base.BaseBizEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-11-23
 */
@Getter
@Setter
public class UserEntity extends BaseBizEntity {

    private String username;

    private String password;

}
