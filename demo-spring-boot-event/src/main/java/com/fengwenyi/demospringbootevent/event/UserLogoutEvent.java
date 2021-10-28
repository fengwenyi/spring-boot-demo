package com.fengwenyi.demospringbootevent.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-10-28
 */
@Getter
public class UserLogoutEvent extends ApplicationEvent {

    private final String uid;

    public UserLogoutEvent(String uid) {
        super(uid);
        this.uid = uid;
    }
}
