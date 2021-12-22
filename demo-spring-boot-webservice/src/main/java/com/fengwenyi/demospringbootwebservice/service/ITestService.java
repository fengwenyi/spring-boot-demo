package com.fengwenyi.demospringbootwebservice.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-12-22
 */
@WebService(
        targetNamespace = "http://service.demospringbootwebservice.fengwenyi.com" // 与接口中的命名空间一致,一般是接口的包名倒
)
public interface ITestService {

    @WebMethod
    String hello();

}
