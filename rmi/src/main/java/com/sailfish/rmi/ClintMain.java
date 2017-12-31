package com.sailfish.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author sailfish
 * @create 2017-12-28-下午9:38
 */
public class ClintMain {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        //引入服务
        HelloService lookup = (HelloService) Naming.lookup("rmi://localhost:8081/helloService");

        System.out.println("服务器端返回:" + lookup.sayHello("sailfish"));  //服务器端返回:Hello,sailfish

    }
}
