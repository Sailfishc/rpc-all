package com.sailfish.provider;

import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;

/**
 */
public class NettyServer {

    private static NettyServer nettyServer = new NettyServer();

    private Channel channel;
    ////服务端boss线程组
    private EventLoopGroup bossGroup;
    //服务端worker线程组
    private EventLoopGroup workerGroup;
    //序列化类型配置信息

    /**
     * 启动Netty服务
     *
     * @param port
     */
    public void start(final int port) {

    }


    /**
     * 停止Netty服务
     */
    public void stop() {
        if (null == channel) {
            throw new RuntimeException("Netty Server Stoped");
        }
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
        channel.closeFuture().syncUninterruptibly();
    }


    private NettyServer() {
    }


    public static NettyServer singleton() {
        return nettyServer;
    }
}
