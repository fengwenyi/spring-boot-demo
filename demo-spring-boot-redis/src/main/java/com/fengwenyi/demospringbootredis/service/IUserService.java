package com.fengwenyi.demospringbootredis.service;

import com.fengwenyi.demospringbootredis.model.UserModel;

import java.util.List;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-08-15
 */
public interface IUserService {

    UserModel queryUser(String id);

    List<UserModel> queryUserList();

    String queryUserName(String id);

}
