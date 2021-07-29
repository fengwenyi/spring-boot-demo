# Spring Boot 参数校验

## 常用注解

| 注解 | 描述 | 
| --- | --- |
| @Null | 限制只能为null |
| @NotNull | 限制必须不为null |
| @AssertFalse | 限制必须为false |
| @AssertTrue | 限制必须为true |
| @DecimalMax(value) | 限制必须为一个不大于指定值的数字 |
| @DecimalMin(value) | 限制必须为一个不小于指定值的数字 |
| @Digits(integer,fraction) | 限制必须为一个小数，且整数部分的位数不能超过integer，小数部分的位数不能超过fraction |
| @Future | 限制必须是一个将来的日期 |
| @Past | 限制必须是一个过去的日期 |
| @Max(value) | 限制必须为一个不大于指定值的数字 |
| @Min(value) | 限制必须为一个不小于指定值的数字 |
| @Pattern(value) | 限制必须符合指定的正则表达式 |
| @Size(max,min) | 限制字符长度必须在min到max之间 |
| @NotEmpty | 验证注解的元素值不为null且不为空（字符串长度不为0、集合大小不为0） |
| @NotBlank | 验证注解的元素值不为空（不为null、去除首位空格后长度为0），不同于@NotEmpty，@NotBlank只应用于字符串且在比较时会去除字符串的空格 |
| @Email | 验证注解的元素值是Email，也可以通过正则表达式和flag指定自定义的email格式 |

## 正则验证

比如验证手机号：

```java
@Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$", message = "手机号格式错误")
private String phone;
```

## 自定义验证注解

验证注解：
```java
package com.fengwenyi.demospringbootvalidated.annotation;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-05-08
 */
//注解是指定当前自定义注解可以使用在哪些地方，这里仅仅让他可以使用在方法上和属性上；

import com.fengwenyi.demospringbootvalidated.validator.IdCardNoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.FIELD})
//指定当前注解保留到运行时；
@Retention(RetentionPolicy.RUNTIME)
//指定了当前注解使用哪个类来进行校验。
@Constraint(validatedBy = IdCardNoValidator.class) //
public @interface IdCardNo {

    String message();
    // default 关键字 接口中被default修饰的方法，在类实现这个接口时不必必须实现这个方法
    Class<?>[] groups() default { };
    // Class<?> 表示不确定的java类型
    // Class<T> 表示java类型
    // Class<K,V> 分别代表java键值中的key value
    // Class<E> 代表Element
    Class<? extends Payload>[] payload() default {};

}
```

实现校验器：
```java
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
```