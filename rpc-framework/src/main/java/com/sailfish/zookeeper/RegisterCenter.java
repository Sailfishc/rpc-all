package com.sailfish.zookeeper;

import com.google.common.collect.Maps;

import com.sailfish.helper.PropertyConfigeHelper;
import com.sailfish.model.InvokerService;
import com.sailfish.model.ProviderService;

import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Map;

/**
 * @author sailfish
 * @create 2017-12-31-下午12:56
 */
public class RegisterCenter implements IRegisterCenter4Invoker, IRegisterCenter4Provider, IRegisterCenter4Governance {

    private static RegisterCenter registerCenter = new RegisterCenter();

    //服务提供者列表,Key:服务提供者接口  value:服务提供者服务方法列表
    private static final Map<String, List<ProviderService>> providerServiceMap = Maps.newConcurrentMap();

    //服务端ZK服务元信息,选择服务(第一次直接从ZK拉取,后续由ZK的监听机制主动更新)
    private static final Map<String, List<ProviderService>> serviceMetaDataMap4Consume = com.google.common.collect.Maps.newConcurrentMap();


    private static String ZK_SERVICE = PropertyConfigeHelper.getZkService();
    private static int ZK_SESSION_TIME_OUT = PropertyConfigeHelper.getZkConnectionTimeout();
    private static int ZK_CONNECTION_TIME_OUT = PropertyConfigeHelper.getZkConnectionTimeout();
    private static String ROOT_PATH = "/config_register";
    public static String PROVIDER_TYPE = "provider";
    public static String INVOKER_TYPE = "consumer";
    private static volatile ZkClient zkClient = null;



    private RegisterCenter() {
    }

    public static RegisterCenter singleton() {
        return registerCenter;
    }

    @Override
    public Pair<List<ProviderService>, List<InvokerService>> queryProvidersAndInvokers(String serviceName, String appKey) {
        return null;
    }

    @Override
    public void initProviderMap(String remoteAppKey, String groupName) {

    }

    @Override
    public Map<String, List<ProviderService>> getServiceMetaDataMap4Consume() {
        return null;
    }

    @Override
    public void registerInvoker(InvokerService invoker) {

    }

    @Override
    public void registerProvider(List<ProviderService> serviceMetaData) {

    }

    @Override
    public Map<String, List<ProviderService>> getProviderServiceMap() {
        return null;
    }
}