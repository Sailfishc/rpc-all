package com.sailfish.cxf.server;

import javax.jws.WebService;

/**
 * @author sailfish
 * @create 2017-12-28-下午9:45
 */
@WebService
public interface HelloService {

    String sayHello(String content);
}

//第一次启动出错：Failed to read manifest from [/Users/sailfish/rpc-all/cxf/target/cxf/META-INF/MANIFEST.MF
