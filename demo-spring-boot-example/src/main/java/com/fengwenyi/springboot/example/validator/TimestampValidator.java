package com.fengwenyi.springboot.example.validator;

import com.fengwenyi.javalib.convert.DateTimeUtils;
import com.fengwenyi.springboot.example.annotation.ValidTimestamp;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-07-08
 */
public class TimestampValidator implements ConstraintValidator<ValidTimestamp, Long> {

    private boolean past = false;
    private boolean future = false;
    private boolean pastOrPresent = false;
    private boolean futureOrPresent = false;

    @Override
    public void initialize(ValidTimestamp constraintAnnotation) {
        past = constraintAnnotation.past();
        future = constraintAnnotation.future();
        pastOrPresent = constraintAnnotation.pastOrPresent();
        futureOrPresent = constraintAnnotation.futureOrPresent();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext constraintValidatorContext) {

        if (Objects.isNull(value)) {
            return true;
        }

        long nowTimestamp = DateTimeUtils.toMillisecond(LocalDateTime.now());

        if (past) {
            return value < nowTimestamp;
        } else if (future) {
            return value > nowTimestamp;
        } else if (pastOrPresent) {
            return value <= nowTimestamp;
        } else if (futureOrPresent) {
            return value >= nowTimestamp;
        }

        return false;
    }
}
