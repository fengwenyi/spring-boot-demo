package com.fengwenyi.demospringbootelasticsearch.domail;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author Erwin Feng
 * @since 2021-05-12
 */
@Data
@Accessors(chain = true)
@Document(indexName = "log")
public class LogModel {

    @Id
    private String id;

    @Field(type = FieldType.Keyword)
    private String keyword;

}
