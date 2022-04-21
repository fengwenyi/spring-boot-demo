package com.fengwenyi.demospringbootjpaspecification.repository;

import com.fengwenyi.demospringbootjpaspecification.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-04-21
 */
@Repository
public interface IUserRepository extends JpaSpecificationExecutor<UserEntity> {
}
