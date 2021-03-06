package com.fengwenyi.demospringbootevent.event;

import com.fengwenyi.demospringbootevent.event.UserLoginEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-18
 */
//@Component
@Slf4j
public class UserLoginEventListener implements ApplicationListener<UserLoginEvent> {
    @Override
    public void onApplicationEvent(UserLoginEvent event) {
        // 记录用户登陆日志
        log.info("用户 {} 登陆", event.getSource());
    }
}
