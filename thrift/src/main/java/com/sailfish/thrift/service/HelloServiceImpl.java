package com.sailfish.thrift.service;

import org.apache.thrift.TException;

/**
 * @author sailfish
 * @create 2017-12-29-上午7:57
 */
public class HelloServiceImpl implements HelloService.Iface {

    @Override
    public String sayHello(User user) throws TException {
        return "hello," + user.getName() + user.getEmail();
    }
}
