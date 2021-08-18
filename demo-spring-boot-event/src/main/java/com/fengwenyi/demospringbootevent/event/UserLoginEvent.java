package com.fengwenyi.demospringbootevent.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-18
 */
public class UserLoginEvent extends ApplicationEvent {
    public UserLoginEvent(Object source) {
        super(source);
    }
}
