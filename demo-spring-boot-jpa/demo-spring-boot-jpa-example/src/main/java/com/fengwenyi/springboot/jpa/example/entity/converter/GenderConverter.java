package com.fengwenyi.springboot.jpa.example.entity.converter;

import com.fengwenyi.springboot.jpa.example.entity.enums.GenderEnum;

import javax.persistence.AttributeConverter;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-07-18
 */
public class GenderConverter implements AttributeConverter<GenderEnum, String> {
    @Override
    public String convertToDatabaseColumn(GenderEnum genderEnum) {
        return genderEnum.getCode();
    }

    @Override
    public GenderEnum convertToEntityAttribute(String code) {
        return GenderEnum.of(code);
    }
}
