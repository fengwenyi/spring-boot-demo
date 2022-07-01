package com.fengwenyi.springboot.elasticsearchclient.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import lombok.Data;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-06-29
 */
@ConfigurationProperties(prefix = "erwin.elasticsearch")//配置配置信息的前缀
@Configuration
@Data
public class ElasticsearchConfig {

    /**
     * 多个IP逗号隔开
     */
    private String uris;

    @Bean
    public RestClient restClient() {
        if (StringUtils.hasText(uris)) {
            return RestClient.builder(
                    Arrays.stream(uris.split(","))
                            .map(HttpHost::create)
                            .toArray(HttpHost[]::new))
                    .build();
        } else {
            throw new RuntimeException("未读取到es的uri配置信息");
        }
    }

    @Bean
    public ElasticsearchClient elasticsearchClient() {
        RestClient client = restClient();
        ElasticsearchTransport transport = new RestClientTransport(client, new JacksonJsonpMapper());
        return new ElasticsearchClient(transport);
    }

}
