package com.fengwenyi.demo.springboot.dm.repository;

import com.fengwenyi.demo.springboot.dm.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-03-30
 */
public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
}
