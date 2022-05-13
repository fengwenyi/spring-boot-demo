package com.fengwenyi.demospringbootfuturetask.service;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;


public interface HttpService {



    FutureTask<String> http(String url, String param);

    Future<String> http2(String url, String param);

}
