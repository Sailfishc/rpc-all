package com.sailfish.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author sailfish
 * @create 2017-12-28-下午9:33
 */
public interface HelloService extends Remote{

    String sayHello(String someOne) throws RemoteException;
}
