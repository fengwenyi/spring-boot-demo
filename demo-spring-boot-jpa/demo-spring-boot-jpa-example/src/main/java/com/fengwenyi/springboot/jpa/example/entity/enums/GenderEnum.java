package com.fengwenyi.springboot.jpa.example.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-07-18
 */
@Getter
@AllArgsConstructor
public enum GenderEnum {

    MALE("M", "男"),
    FEMALE("F", "女"),

    ;

    private final String code;

    private final String msg;

    public static GenderEnum of(String code) {
        return Stream.of(values())
                .filter(bean -> bean.code.equals(code))
                .findAny()
                .orElseThrow(
                        () -> new IllegalArgumentException(code + " not exists")
                );
    }

}
