package com.fengwenyi.demospringbootredis.service.impl;

import com.fengwenyi.demospringbootredis.model.UserModel;
import com.fengwenyi.demospringbootredis.model.UserSimple;
import com.fengwenyi.demospringbootredis.service.IUserService;
import com.fengwenyi.javalib.convert.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-08-15
 */
@Service
public class UserServiceImpl implements IUserService {

    private StringRedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

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


    String USER_SIMPLE_LIST = "user:simple:list";

    @Override
    public List<UserSimple> queryUserSimpleList(List<String> ids) {

        List<Object> cIds = ids.stream().map(String::new).collect(Collectors.toList());

        List<Object> userSimpleList =  redisTemplate.opsForHash().multiGet(USER_SIMPLE_LIST, cIds)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        if (CollectionUtils.isEmpty(userSimpleList)) {
            return queryUserSimpleListFromDbToCache(ids);
        } else {
            if (userSimpleList.size() == ids.size()) {
                return parseCachedUserSimpleList(userSimpleList);
            } else {

                // 左
                List<UserSimple> left = parseCachedUserSimpleList(userSimpleList);

                List<String> leftIds = left.stream().map(UserSimple::getUid).collect(Collectors.toList());

                // 右 id
                List<String> rightIds = ids.stream().filter(leftIds::contains).collect(Collectors.toList());

                return queryUserSimpleListFromDbToCache(rightIds);
            }
        }
    }

    private List<UserSimple> parseCachedUserSimpleList(List<Object> cachedUserSimpleList) {
        return cachedUserSimpleList.stream()
                .map(u -> JsonUtils.convertObject(u.toString(), UserSimple.class))
                .collect(Collectors.toList());
    }

    private List<UserSimple> queryUserSimpleListFromDbToCache(List<String> ids) {

        List<UserModel> userModelList = query();

        List<UserSimple> userSimpleList = userModelList.stream().map(u -> new UserSimple()).collect(Collectors.toList());

        Map<String, String> userSimpleMap = new HashMap<>();

        userSimpleList.forEach(u -> {
            userSimpleMap.put(u.getUid(), JsonUtils.convertString(u));
        });

        redisTemplate.opsForHash().putAll(USER_SIMPLE_LIST, userSimpleMap);

        return userSimpleList;
    }

    private List<UserModel> query() {
        return new ArrayList<>();
    }
}
