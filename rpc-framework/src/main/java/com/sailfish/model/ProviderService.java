package com.sailfish.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.lang.reflect.Method;

import lombok.Getter;
import lombok.Setter;

/**
 * 服务注册中心的服务提供者注册信息
 * @author sailfish
 * @create 2017-12-31-下午12:50
 */
@Getter
@Setter
public class ProviderService implements Serializable {


    private Class<?> serviceItf;
    private transient Object serviceObject;
    @JsonIgnore
    private transient Method serviceMethod;
    private String serverIp;
    private int serverPort;
    private long timeout;
    //该服务提供者权重
    private int weight;
    //服务端线程数
    private int workerThreads;
    //服务提供者唯一标识
    private String appKey;
    //服务分组组名
    private String groupName;

    public ProviderService copy() {
        ProviderService providerService = new ProviderService();
        providerService.setServiceItf(serviceItf);
        providerService.setServiceObject(serviceObject);
        providerService.setServiceMethod(serviceMethod);
        providerService.setServerIp(serverIp);
        providerService.setServerPort(serverPort);
        providerService.setTimeout(timeout);
        providerService.setWeight(weight);
        providerService.setWorkerThreads(workerThreads);
        providerService.setAppKey(appKey);
        providerService.setGroupName(groupName);
        return providerService;
    }
}
