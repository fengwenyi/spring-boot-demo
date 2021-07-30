package com.fengwenyi.demospringbootnettyservernew;

import com.fengwenyi.demospringbootnettyservernew.handler.NettyServerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import org.springframework.stereotype.Component;

/**
 * netty服务初始化器
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-21
 */
@Component
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    private final NettyServerHandler nettyServerHandler;

    public ServerChannelInitializer(NettyServerHandler nettyServerHandler) {
        this.nettyServerHandler = nettyServerHandler;
    }

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //添加编解码
        socketChannel.pipeline().addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
        socketChannel.pipeline().addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
        socketChannel.pipeline().addLast(nettyServerHandler);
    }
}
