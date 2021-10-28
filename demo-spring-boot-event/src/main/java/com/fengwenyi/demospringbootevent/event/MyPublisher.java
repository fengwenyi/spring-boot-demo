package com.fengwenyi.demospringbootevent.event;

import com.fengwenyi.demospringbootevent.event.ExceptionEvent;
import com.fengwenyi.demospringbootevent.event.UserLoginEvent;
import com.fengwenyi.demospringbootevent.vo.request.UserLoginRequestVo;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-18
 */
@Component
public class MyPublisher {

    private final ApplicationContext applicationContext;

    public MyPublisher(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void userLoginEvent(String username) {
        applicationContext.publishEvent(new UserLoginEvent(username));
    }

    public void alarm(String msg) {
        applicationContext.publishEvent(new ExceptionEvent(msg));
    }

    public void logout(String uid) {
        applicationContext.publishEvent(new UserLogoutEvent(uid));
    }
}
