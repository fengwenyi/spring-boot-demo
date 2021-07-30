package com.fengwenyi.demospringbootnettyservernew;

import com.fengwenyi.demospringbootnettyservernew.config.NettyConfiguration;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-30
 */
@Component
@Slf4j
public class NettyBootstrapRunner implements ApplicationRunner, ApplicationListener<ContextClosedEvent> {

    private final NettyConfiguration nettyConfiguration;
    private final ServerChannelInitializer serverChannelInitializer;

    public NettyBootstrapRunner(NettyConfiguration nettyConfiguration, ServerChannelInitializer serverChannelInitializer) {
        this.nettyConfiguration = nettyConfiguration;
        this.serverChannelInitializer = serverChannelInitializer;
    }

    private EventLoopGroup bossGroup;
    private EventLoopGroup workGroup;
    private Channel channel;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(nettyConfiguration.getIp(), nettyConfiguration.getPort());
        //new 一个主线程组
         bossGroup = new NioEventLoopGroup(1);
        //new 一个工作线程组
         workGroup = new NioEventLoopGroup(200);
        ServerBootstrap bootstrap = new ServerBootstrap()
                .group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(serverChannelInitializer)
                .localAddress(inetSocketAddress)
                //设置队列大小
                .option(ChannelOption.SO_BACKLOG, 1024)
                // 两小时内没有数据的通信时,TCP会自动发送一个活动探测数据报文
                .childOption(ChannelOption.SO_KEEPALIVE, true);
        //绑定端口,开始接收进来的连接
        try {
            ChannelFuture future = bootstrap.bind(inetSocketAddress).sync();
            channel = future.channel();
            log.info("Socket服务器启动，开始监听端口: {}", inetSocketAddress.getPort());
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            channel.close();
            //关闭主线程组
            bossGroup.shutdownGracefully();
            //关闭工作线程组
            workGroup.shutdownGracefully();
        }
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        if (channel != null && channel.isActive()) {
            channel.close();
        }
        if (bossGroup != null && !bossGroup.isShutdown()) {
            //关闭主线程组
            bossGroup.shutdownGracefully();
        }
        if (workGroup != null && !workGroup.isShutdown()) {
            //关闭工作线程组
            workGroup.shutdownGracefully();
        }
    }
}
