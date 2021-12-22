package com.fengwenyi.demospringbootwebservice.util;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import java.util.Objects;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-12-22
 */
public class WebServiceUtils {

    private static final long DEFAULT_CONN_TIMEOUT = 5_000;
    private static final long DEFAULT_READ_TIMEOUT = 45_000;

    public static String call(String url, String method, String param) {
        return call(url, method, param, DEFAULT_READ_TIMEOUT);
    }

    public static String call(String url, String method, String param, long timeout) {
        //创建动态客户端
        JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
        Client client = factory.createClient(url);
        // 需要密码的情况需要加上用户名和密码
        //client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,PASS_WORD));
        HTTPConduit conduit = (HTTPConduit) client.getConduit();
        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(DEFAULT_CONN_TIMEOUT);  //连接超时
        httpClientPolicy.setAllowChunking(false);    //取消块编码
        httpClientPolicy.setReceiveTimeout(timeout);     //响应超时
        conduit.setClient(httpClientPolicy);
        //client.getOutInterceptors().addAll(interceptors);//设置拦截器
        try{
            Object[] objects = client.invoke(method, param);
            return objects[0] + "";
        }catch (Exception e){
            System.err.println("err: " + e.getLocalizedMessage());
        }
        return "";
    }

    static class WebServiceClient {

        static WebServiceClient webServiceClient;
        static Client client;

        public static WebServiceClient getInstance(String url) {
            if (Objects.isNull(client)) {
                JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
                Client client = factory.createClient(url);
            }
//            return client;
            return null;
        }

        public void login(String user, String pwd) {
//            client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,PASS_WORD));
        }

    }

}
