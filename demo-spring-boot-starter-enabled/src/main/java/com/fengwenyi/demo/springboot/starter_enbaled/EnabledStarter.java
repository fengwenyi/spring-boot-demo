package com.fengwenyi.demo.springboot.starter_enbaled;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-11-21
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({StarterAutoConfig.class})
public @interface EnabledStarter {
}
