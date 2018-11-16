package com.ysdevelop.websocket.manager;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChannelHandlerContextManager {
	private static final Map<Long, ChannelHandlerContext> map = new ConcurrentHashMap<>();

	public static void addChannelHandlerContext(Long userId, ChannelHandlerContext context) {
		map.put(userId, context);
	}

	public static void removeChannelHandlerContext(Long userId) {
		ChannelHandlerContext context = map.get(userId);
		context.close();
		map.remove(userId);
	}

	public static ChannelHandlerContext getContextByUserId(Long userId) {
		ChannelHandlerContext context = map.get(userId);
		if (context == null) {
			return null;
		} else {
			return context;
		}
	}

	/**
	 * 发送消息给客户端
	 * 
	 * @param ctx
	 * @param msg
	 * @throws Exception
	 * 
	 */
	public static void sendWebSocket(ChannelHandlerContext ctx, String msg) throws Exception {
		if (ctx == null || ctx.isRemoved()) {
			throw new Exception("尚未握手成功,无法向客户端发送WebSocket消息");
		}
		ctx.channel().write(new TextWebSocketFrame(msg));
		ctx.flush();
	}

}
