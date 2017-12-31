package com.sailfish.cxf.server;

import javax.jws.WebService;

/**
 * @author sailfish
 * @create 2017-12-28-下午9:46
 */
//指定实现的是helloService接口
@WebService(endpointInterface = "com.sailfish.cxf.server.HelloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String content) {
        return "hello," + content;
    }
}
