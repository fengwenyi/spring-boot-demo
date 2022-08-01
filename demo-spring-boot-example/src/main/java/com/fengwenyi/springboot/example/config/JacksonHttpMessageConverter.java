package com.fengwenyi.springboot.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-08-01
 */
//@Configuration
public class JacksonHttpMessageConverter extends MappingJackson2HttpMessageConverter {

    public JacksonHttpMessageConverter() {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializerFactory(
                objectMapper.getSerializerFactory()
                        .withSerializerModifier(new MyBeanSerializerModifier()));

    }
}
