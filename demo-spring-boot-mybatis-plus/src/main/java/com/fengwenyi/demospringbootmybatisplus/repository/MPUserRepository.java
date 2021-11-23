package com.fengwenyi.demospringbootmybatisplus.repository;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fengwenyi.demospringbootmybatisplus.entity.UserEntity;
import org.springframework.stereotype.Service;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-11-23
 */
@Service
public interface MPUserRepository extends IService<UserEntity> {
}
