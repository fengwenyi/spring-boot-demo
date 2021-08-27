package com.fengwenyi.demospringbootaop.service;


import com.fengwenyi.demospringbootaop.entity.TUserEntity;

/**
 * @author Erwin Feng
 * @since 2020/9/13
 */
public interface IUserService {

    TUserEntity queryById(String id);

}
