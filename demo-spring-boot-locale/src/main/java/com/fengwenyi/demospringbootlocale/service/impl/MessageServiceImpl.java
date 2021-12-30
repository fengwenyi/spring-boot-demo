package com.fengwenyi.demospringbootlocale.service.impl;

import com.fengwenyi.demospringbootlocale.service.IMessageService;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-12-30
 */
@Service
public class MessageServiceImpl implements IMessageService {

    private final MessageSource messageSource;

    public MessageServiceImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String getMessage(String code) {
        return getMessage(code, null);
    }

    @Override
    public String getMessage(String code, Object[] args) {
        return getMessage(code, args, "");
    }

    @Override
    public String getMessage(String code, Object[] args, String defaultMessage) {
        String message;
        try {
            message = messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
        } catch (Exception e) {
            message = defaultMessage;
        }
        return message;
    }
}
