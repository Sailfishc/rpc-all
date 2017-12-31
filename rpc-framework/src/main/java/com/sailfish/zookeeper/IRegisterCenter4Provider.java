package com.sailfish.zookeeper;

import com.sailfish.model.ProviderService;

import java.util.List;
import java.util.Map;

/**
 * @author sailfish
 * @create 2017-12-31-下午1:16
 */
public interface IRegisterCenter4Provider {

    /**
     * 服务端将服务提供者信息注册到zk对应的节点下
     *
     * @param serviceMetaData
     */
    void registerProvider(final List<ProviderService> serviceMetaData);


    /**
     * 服务端获取服务提供者信息
     * <p/>
     * 注:返回对象,Key:服务提供者接口  value:服务提供者服务方法列表
     */
    Map<String, List<ProviderService>> getProviderServiceMap();
}
