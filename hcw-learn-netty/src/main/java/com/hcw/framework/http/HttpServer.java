package com.hcw.framework.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

public class HttpServer {

    public static void main(String[] args)  {
        EventLoopGroup bossEventLoopGroup = new NioEventLoopGroup(1);
        EventLoopGroup workEventLoopGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossEventLoopGroup, workEventLoopGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) {
                                socketChannel.pipeline().addLast(new HttpRequestDecoder());
                                socketChannel.pipeline().addLast(new HttpObjectAggregator(65536));
                                socketChannel.pipeline().addLast(new HttpResponseEncoder());
                                socketChannel.pipeline().addLast(new HttpSimpleHandler());
                        }
                    });
            ChannelFuture channelFuture = bootstrap.bind(8080).sync();
            System.out.println("http server is started, port:8080");
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            bossEventLoopGroup.shutdownGracefully();
            workEventLoopGroup.shutdownGracefully();
        }
    }
}
