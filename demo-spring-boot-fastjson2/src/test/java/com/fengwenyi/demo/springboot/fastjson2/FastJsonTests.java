package com.fengwenyi.demo.springboot.fastjson2;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-05-09
 */
public class FastJsonTests {

    @Test
    public void getKeys() {

//        String json = "{\"other\":{\"myWeb\":\"https://fengwenyi.com\",\"github\":\"https://github.com/fengwenyi\"},\"like\":[\"movie\",\"game\",\"music\",\"tea\",\"travel\"],\"sex\":\"男\",\"name\":\"冯文议\",\"age\":28}";
        String json = "{\"other\":{\"myWeb\":\"https://fengwenyi.com\",\"github\":\"https://github.com/fengwenyi\"},\"like\":[\"movie\",\"game\",\"music\",\"tea\",\"travel\"],\"sex\":\"男\",\"name\":\"冯文议\",\"age\":28,\"school\":[{\"name\":\"小学\"},{\"name\":\"中学\"}]}";
        JSONObject jsonObject = JSON.parseObject(json);
        Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey());
        }
    }

}
