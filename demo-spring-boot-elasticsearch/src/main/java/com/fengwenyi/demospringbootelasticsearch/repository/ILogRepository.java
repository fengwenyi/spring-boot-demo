package com.fengwenyi.demospringbootelasticsearch.repository;

import com.fengwenyi.demospringbootelasticsearch.domail.LogModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Erwin Feng
 * @since 2021-05-12
 */
@Repository
public interface ILogRepository extends ElasticsearchRepository<LogModel, String> {
}
