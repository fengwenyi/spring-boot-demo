package com.fengwenyi.springboot.security;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-12-10
 */
public class BCryptPasswordTests {

    @Test
    public void testGenPassword() {
        String text = "123456";
        String pwd = new BCryptPasswordEncoder().encode(text);
        System.out.println(pwd);
    }

}
