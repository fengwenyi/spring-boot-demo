package com.fengwenyi.demospringbootlocale.service;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-12-30
 */
public interface IMessageService {

    String getMessage(String code);
    String getMessage(String code, Object [] args);
    String getMessage(String code, Object [] args, String defaultMessage);

}
