package com.fengwenyi.demo.springboot.aop.service;


import com.fengwenyi.demo.springboot.aop.entity.TUserEntity;

/**
 * @author Erwin Feng
 * @since 2020/9/13
 */
public interface IUserService {

    TUserEntity queryById(String id);

}
