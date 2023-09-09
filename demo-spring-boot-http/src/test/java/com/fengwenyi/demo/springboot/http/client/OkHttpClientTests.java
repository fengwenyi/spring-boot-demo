package com.fengwenyi.demo.springboot.http.client;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-09-09
 */
@Slf4j
public class OkHttpClientTests {

    /* get */
    // get 无参数
    @Test
    public void testGetNotParam() {
        String url = "";
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(url).build();

        String result;

        try (Response response = client.newCall(request).execute()) {
            result = Objects.requireNonNull(response.body()).string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info(result);
    }

    // get 有参数
    @Test
    public void testGetParam() {
        String url = "";
        Map<String, String> paramMap = new HashMap<>();

        HttpUrl.Builder httpUrlBuilder = new HttpUrl.Builder();

        paramMap.forEach((k, v) -> {
            httpUrlBuilder.addQueryParameter(k, v);
        });

        HttpUrl httpUrl = httpUrlBuilder.build();


        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder().url(httpUrl).get().build();

        String result;
        try {
            result = Objects.requireNonNull(okHttpClient.newCall(request).execute().body()).string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info(result);
    }

    // get https

}
