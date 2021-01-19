package com.hcw.framework;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class ChildChannelHandler extends ChannelInitializer {


    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline().addLast("tcp", new ByteToMessageDecoder() {
            @Override
            protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
                byte[] bytes = new byte[in.readableBytes()];
                in.readBytes(bytes);
                String a = new String(bytes,"utf-8");
                System.out.println(a);
            }
        });
    }
}
