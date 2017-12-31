package com.sailfish.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author sailfish
 * @create 2017-12-28-下午9:36
 */
public class ServerMain {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        HelloService helloService = new HelloServiceImpl();

        //注册服务
        LocateRegistry.createRegistry(8081);

        Naming.bind("rmi://localhost:8081/helloService", helloService);
        System.out.println("Server main provide RPC");

    }
}
