package com.sailfish.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author sailfish
 * @create 2017-12-28-下午9:34
 */
public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {

    private static final long serialVersionUID = 0L;


    public HelloServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String someOne) throws RemoteException {
        return "Hello," + someOne;
    }
}
