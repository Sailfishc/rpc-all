package com.sailfish.model;

import java.io.Serializable;
import java.lang.reflect.Method;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sailfish
 * @create 2017-12-31-下午12:57
 */
@Getter
@Setter
public class InvokerService implements Serializable{

    private Class<?> serviceItf;
    private Object serviceObject;
    private Method serviceMethod;
    private String invokerIp;
    private int invokerPort;
    private long timeout;
    //服务提供者唯一标识
    private String remoteAppKey;
    //服务分组组名
    private String groupName = "default";
}
