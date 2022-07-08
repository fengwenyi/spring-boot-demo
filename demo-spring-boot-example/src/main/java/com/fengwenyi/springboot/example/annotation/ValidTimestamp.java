package com.fengwenyi.springboot.example.annotation;

import com.fengwenyi.springboot.example.validator.TimestampValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-07-08
 */
@Constraint(validatedBy = {TimestampValidator.class})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
public @interface ValidTimestamp {

    String message() default "timestamp invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    boolean past() default false;

    boolean future() default false;

    boolean pastOrPresent() default false;

    boolean futureOrPresent() default false;

}
