package com.fengwenyi.demo.springboot.shardingjdbc.repository;

import com.fengwenyi.demo.springboot.shardingjdbc.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2024-01-18
 */
public interface LogRepository extends JpaRepository<LogEntity, Long> {
}
