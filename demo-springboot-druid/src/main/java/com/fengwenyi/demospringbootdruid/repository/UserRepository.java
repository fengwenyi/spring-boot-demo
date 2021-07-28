package com.fengwenyi.demospringbootdruid.repository;

import com.fengwenyi.demospringbootdruid.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Erwin Feng
 * @since 2019/8/26 09:44
 */
public interface UserRepository extends JpaRepository<UserModel, String> {
}
