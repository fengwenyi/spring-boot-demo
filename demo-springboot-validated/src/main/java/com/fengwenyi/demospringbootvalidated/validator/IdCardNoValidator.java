package com.fengwenyi.demospringbootvalidated.validator;

import com.fengwenyi.demospringbootvalidated.annotation.IdCardNo;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-05-08
 */
public class IdCardNoValidator implements ConstraintValidator<IdCardNo, String> {
    @Override
    public void initialize(IdCardNo constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String idCardNo, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.hasText(idCardNo)) {
            return idCardNo.length() == 18 || idCardNo.length() == 15;
        } else {
            // 是空，不做校验
            return true;
        }
    }
}
