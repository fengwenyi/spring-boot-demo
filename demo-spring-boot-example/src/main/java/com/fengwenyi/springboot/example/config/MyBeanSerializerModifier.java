package com.fengwenyi.springboot.example.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fengwenyi.springboot.example.annotation.JacksonAllowNull;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-08-01
 */
public class MyBeanSerializerModifier extends BeanSerializerModifier {

    String BLANK = "";

    @Override
    public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyWriter> beanProperties) {
        for (Object beanProperty : beanProperties) {
            BeanPropertyWriter writer = (BeanPropertyWriter) beanProperty;
            /* 过滤允许为null的注解 */
            if (Objects.isNull(writer.getAnnotation(JacksonAllowNull.class))) {
                if (isArrayType(writer)) {
                    writer.assignNullSerializer(new NullArrayJsonSerializer());
                } else if (isNumberType(writer)) {
                    writer.assignNullSerializer(new NullNumberJsonSerializer());
                } else if (isBooleanType(writer)) {
                    writer.assignNullSerializer(new NullBooleanJsonSerializer());
                } else if (isStringType(writer)) {
                    writer.assignNullSerializer(new NullStringJsonSerializer());
                }
            }
            /* 防止Long精度丢失 */
            // if(isLongType(writer)){
            // writer.assignSerializer(new ToStringSerializer());
            // }
        }
        return beanProperties;
    }

    private boolean isArrayType(BeanPropertyWriter writer) {
        Class<?> clazz = writer.getType().getRawClass();
        return clazz.isArray() || Collection.class.isAssignableFrom(clazz);
    }

    private boolean isStringType(BeanPropertyWriter writer) {
        Class<?> clazz = writer.getType().getRawClass();
        return CharSequence.class.isAssignableFrom(clazz) || Character.class.isAssignableFrom(clazz);
    }

    private boolean isNumberType(BeanPropertyWriter writer) {
        Class<?> clazz = writer.getType().getRawClass();
        return Number.class.isAssignableFrom(clazz);
    }

    private boolean isLongType(BeanPropertyWriter writer) {
        Class<?> clazz = writer.getType().getRawClass();
        return Long.class.isAssignableFrom(clazz);
    }

    private boolean isBooleanType(BeanPropertyWriter writer) {
        Class<?> clazz = writer.getType().getRawClass();
        return clazz.equals(Boolean.class);
    }


    private static class NullArrayJsonSerializer extends JsonSerializer<Object> {
        @Override
        public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
            if (o == null) {
                jsonGenerator.writeStartArray();
                jsonGenerator.writeEndArray();
            }
        }
    }

    private class NullStringJsonSerializer extends JsonSerializer<Object> {
        @Override
        public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(BLANK);
        }
    }

    private static class NullNumberJsonSerializer extends JsonSerializer<Object> {
        @Override
        public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumber(0);
        }
    }

    private static class NullBooleanJsonSerializer extends JsonSerializer<Object> {
        @Override
        public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeBoolean(false);
        }
    }

}


