package com.hcw.framework.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * FullHttpRequest 需要HttpObjectAggregator配合
 * http短连接，需要加上.addListener(ChannelFutureListener.CLOSE)
 */
public class HttpSimpleHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest request) throws Exception {
        URI  uri = new URI(request.uri());
        if (uri.getPath().equals("/favicon.ico")) {
            return;
        }
        System.out.println("request url=["+uri.getPath()+"] payLoad=["+uri.getQuery()+"]");

        FullHttpResponse httpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
        StringBuffer buf = new StringBuffer("hello,netty!");
        ByteBuf byteBuf = Unpooled.copiedBuffer(buf, CharsetUtil.UTF_8);
        httpResponse.content().writeBytes(byteBuf);
        httpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE,HttpHeaderValues.APPLICATION_JSON);
        byteBuf.release();
        channelHandlerContext.writeAndFlush(httpResponse)
                .addListener(ChannelFutureListener.CLOSE);
    }
}
