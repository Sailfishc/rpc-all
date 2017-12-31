package com.sailfish.cxf.client;

import com.sailfish.cxf.server.HelloService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sailfish
 * @create 2017-12-28-下午10:06
 */
public class CxfClient {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:cxf-client.xml");
        HelloService helloClient = (HelloService) context.getBean("helloClient");
        System.out.println("服务器端响应:" + helloClient.sayHello("sailfish"));  //服务器端响应:hello,sailfish
    }
}
