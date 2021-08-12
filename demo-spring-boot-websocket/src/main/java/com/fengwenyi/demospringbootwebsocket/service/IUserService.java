package com.fengwenyi.demospringbootwebsocket.service;

import com.fengwenyi.demospringbootwebsocket.domain.UserModel;

import java.util.List;


/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-12
 */
public interface IUserService {

    void add(UserModel userModel);

    List<UserModel> queryAll();

    UserModel queryById(String id);

    void deleteById(String id);

}
