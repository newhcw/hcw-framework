package com.hcw.framework;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class ChildChannelHandler extends ChannelInitializer {


    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline()
                .addLast(new LineBasedFrameDecoder(1024))
                .addLast(new StringDecoder())
                .addLast(new HcwHandler());
    }
}
