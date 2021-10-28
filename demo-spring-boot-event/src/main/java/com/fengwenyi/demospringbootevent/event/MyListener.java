package com.fengwenyi.demospringbootevent.event;

import com.fengwenyi.demospringbootevent.event.ExceptionEvent;
import com.fengwenyi.demospringbootevent.event.UserLoginEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-18
 */
@Component
@Slf4j
public class MyListener {

    @EventListener
    public void onApplicationEvent(UserLoginEvent event) {
        // 记录用户登陆日志
        log.info("用户 {} 登陆", event.getSource());
    }

    @EventListener
    @Async
    public void alarm(ExceptionEvent event) {
        log.info("异常信息，触发报警系统，--- {}", event.getSource());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("报警系统处理完成");
    }

    @EventListener
    @Async
    public void sms(ExceptionEvent event) {
        log.info("异常信息，触发sms系统，--- {}", event.getSource());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("sms系统处理完成");
    }
}
