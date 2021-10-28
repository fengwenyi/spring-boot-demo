package com.fengwenyi.demospringbootevent.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-10-28
 */
public class ExceptionEvent extends ApplicationEvent {
    public ExceptionEvent(Object source) {
        super(source);
    }
}
