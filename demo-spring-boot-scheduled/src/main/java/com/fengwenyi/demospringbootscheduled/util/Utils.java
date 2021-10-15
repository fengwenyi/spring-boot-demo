package com.fengwenyi.demospringbootscheduled.util;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-10-15
 */
public class Utils {

    public static int genRandom(int max) {
        return ThreadLocalRandom.current().nextInt(max);
    }

    public static String genId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
