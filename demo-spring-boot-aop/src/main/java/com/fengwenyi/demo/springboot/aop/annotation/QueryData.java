package com.fengwenyi.demo.springboot.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Erwin Feng
 * @since 2020/9/12
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface QueryData {

    String key();

    String cacheName();

    boolean needLog() default false;

}
