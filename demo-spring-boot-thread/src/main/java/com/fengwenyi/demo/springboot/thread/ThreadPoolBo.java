package com.fengwenyi.demo.springboot.thread;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-11
 */
@Data
@Accessors(chain = true)
public class ThreadPoolBo {

    private String ip;

    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    private Integer queueCapacity;

}
