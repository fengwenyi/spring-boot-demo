package com.fengwenyi.springboot.jpa.example.repository;

import com.fengwenyi.springboot.jpa.example.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-04-21
 */
@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
}
