package com.fengwenyi.demospringbootwebsocket.service.impl;

import com.fengwenyi.demospringbootwebsocket.domain.UserModel;
import com.fengwenyi.demospringbootwebsocket.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-12
 */
@Service
public class UserServiceImpl implements IUserService {

    private final ConcurrentMap<String, UserModel> map = new ConcurrentHashMap<>();


    @Override
    public void add(UserModel userModel) {
        map.put(userModel.getId(), userModel);
    }

    @Override
    public List<UserModel> queryAll() {
        return (List<UserModel>) map.values();
    }

    @Override
    public UserModel queryById(String id) {
        return map.get(id);
    }

    @Override
    public void deleteById(String id) {
        map.remove(id);
    }
}
