package com.fengwenyi.springboot.example.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-08-01
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
public @interface JacksonAllowNull {
}
