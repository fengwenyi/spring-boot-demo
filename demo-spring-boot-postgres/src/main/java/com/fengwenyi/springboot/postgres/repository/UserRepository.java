package com.fengwenyi.springboot.postgres.repository;

import com.fengwenyi.springboot.postgres.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-07-01
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
