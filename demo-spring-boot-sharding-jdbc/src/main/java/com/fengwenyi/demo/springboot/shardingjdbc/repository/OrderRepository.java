package com.fengwenyi.demo.springboot.shardingjdbc.repository;

import com.fengwenyi.demo.springboot.shardingjdbc.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-06-30
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
