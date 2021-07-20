package com.fengwenyi.demospringbootnettyclient;

import com.fengwenyi.demospringbootnettyclient.handler.NettyClientHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * 客户端初始化器
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-21
 */
public class NettyClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast("decoder", new StringDecoder());
        socketChannel.pipeline().addLast("encoder", new StringEncoder());
        socketChannel.pipeline().addLast(new NettyClientHandler());
    }

}
