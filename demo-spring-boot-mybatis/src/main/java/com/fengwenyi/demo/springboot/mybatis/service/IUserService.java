package com.fengwenyi.demo.springboot.mybatis.service;

import com.fengwenyi.api.result.PageTemplate;
import com.fengwenyi.demo.springboot.mybatis.entity.UserEntity;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-11-07
 */
public interface IUserService {

    PageTemplate<UserEntity> getPage();

}
