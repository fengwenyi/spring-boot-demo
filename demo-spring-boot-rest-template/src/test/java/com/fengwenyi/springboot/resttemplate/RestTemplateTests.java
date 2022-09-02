package com.fengwenyi.springboot.resttemplate;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-09-02
 */
@Slf4j
public class RestTemplateTests {

    @Test
    public void testRequestBaidu() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("https://baidu.com", String.class);
        log.info(result);
    }

    @Test
    public void testErwinApi() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("https://erwin-api.fengwenyi.com/erwin/blog/page?currentPage=1&pageSize=10", String.class);
        log.info(result);
    }

    @Test
    public void testErwinApiByOkHttp() {
        RestTemplate restTemplate = new RestTemplate(new OkHttp3ClientHttpRequestFactory());
        String result = restTemplate.getForObject("https://erwin-api.fengwenyi.com/erwin/blog/page?currentPage=1&pageSize=10", String.class);
        log.info(result);
    }

}
