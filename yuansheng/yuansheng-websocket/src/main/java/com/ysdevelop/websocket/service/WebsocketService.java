package com.ysdevelop.websocket.service;

import io.netty.channel.ChannelHandlerContext;

import com.ysdevelop.websocket.entity.WebsocketMessage;

public interface WebsocketService {
    void getWebsocketMessage(WebsocketMessage message,ChannelHandlerContext context);
}
