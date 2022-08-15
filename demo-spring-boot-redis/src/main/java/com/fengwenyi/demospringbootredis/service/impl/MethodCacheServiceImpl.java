package com.fengwenyi.demospringbootredis.service.impl;

import com.fengwenyi.demospringbootredis.model.UserModel;
import com.fengwenyi.demospringbootredis.service.IMethodCacheService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-08-15
 */
@Service
public class MethodCacheServiceImpl implements IMethodCacheService {
    @Override
    @Cacheable(value = "user", key = "'id_'+#id")
    public UserModel queryUser(String id) {
        return new UserModel().setUid(id).setName("张三").setAge(20);
    }

    @Cacheable(value = "user", key = "'users'")
    public List<UserModel> queryUserList() {
        List<UserModel> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new UserModel().setUid("u" + i).setName("u" + i).setAge(20));
        }
        return list;
    }

    @Override
    @Cacheable(value = "user", key = "#id")
    public String queryUserName(String id) {
        return "u" + id;
    }
}
