package com.fengwenyi.demospringboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-13
 */
@SpringBootApplication
class DemoSpringBootKotlinApplication

fun main(args: Array<String>) {
    runApplication<DemoSpringBootKotlinApplication>(*args)
}

