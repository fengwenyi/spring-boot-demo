package com.fengwenyi.demo.springboot.bean.condition;

import com.fengwenyi.demo.springboot.bean.SpringBeanApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-11-29
 */
public class ConditionTests extends SpringBeanApplicationTests {

    @Autowired
    private Computer computer;

    @Test
    public void testComputerBean() {
        System.out.println(computer.name);
    }

}
