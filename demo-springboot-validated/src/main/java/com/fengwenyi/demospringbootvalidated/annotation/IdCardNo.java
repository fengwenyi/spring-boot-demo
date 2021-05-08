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
