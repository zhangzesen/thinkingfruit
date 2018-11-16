package com.ysdevelop.websocket.service.impl;

import io.netty.channel.ChannelHandlerContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.common.redis.RedisService;
import com.ysdevelop.common.utils.JSONHelper;
import com.ysdevelop.mq.bo.QueueMessage;
import com.ysdevelop.mq.observer.MessageObserver;
import com.ysdevelop.mq.server.WebsocketMessageConsume;
import com.ysdevelop.websocket.define.WebsocketMessageType;
import com.ysdevelop.websocket.entity.WebsocketMessage;
import com.ysdevelop.websocket.manager.ChannelHandlerContextManager;
import com.ysdevelop.websocket.service.WebsocketService;

@Service
public class WebsocketMessageServiceImpl implements WebsocketService, MessageObserver, InitializingBean {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private WebsocketMessageConsume consume;
	
	@Autowired
	private RedisService redisService;

	@Override
	public void afterPropertiesSet() throws Exception {
		consume.addObserver(this);
	}

	// 处理来自队列的消息
	@Override
	public void updateMessage(String message) {
		try {
			QueueMessage queueMessage = JSONHelper.fromJsonToObject(message, QueueMessage.class);
			Long toUserId = queueMessage.getToUserId();
			Long fromUserId = queueMessage.getFromUserId();
			String content = queueMessage.getContent();
			sendMessage(fromUserId,toUserId, content);
		} catch (Exception e) {
			logger.error("send websocket msg error !!!");
			e.printStackTrace();
		}

	}

	// 发送消息给在线客户端消息e
	private void sendMessage(Long fromUserId,Long toUserId, String content) throws Exception {
		if (toUserId == null) {
			throw new NullPointerException("to userId is null");
		} else {
			// 接受信息的context
			ChannelHandlerContext receiveContext = ChannelHandlerContextManager.getContextByUserId(toUserId);
			if (receiveContext == null) {
				// 将消息缓存为离线消息
				logger.info("客户端端用户未在线");
				// 发送给发送者,接受者不在线
				ChannelHandlerContext sendContext = ChannelHandlerContextManager.getContextByUserId(fromUserId);
				if( sendContext!= null){
					// 将消息缓存在redis中
					ChannelHandlerContextManager.sendWebSocket(sendContext, "接受者不在线");
				}
				
			} else {
				ChannelHandlerContextManager.sendWebSocket(receiveContext, content);
			}

		}

	}

	// 处理来自客户端websockt的消息
	@Override
	public void getWebsocketMessage(WebsocketMessage message, ChannelHandlerContext context) {
		WebsocketMessageType messageType = message.getMessageType();
		Long toUserId = message.getToUserId();
		Long fromUserId = message.getFromUserId();
		try {
			switch (messageType) {
			case ON_LINE:
				// 如果上线将ChannelHandlerContext添加到管理者中
				
				if (fromUserId == null) {
					ChannelHandlerContextManager.sendWebSocket(context, "未收到用户的id");
				} else {
					ChannelHandlerContextManager.addChannelHandlerContext(fromUserId, context);
					ChannelHandlerContextManager.sendWebSocket(context, "用户上线成功");
				}
				break;
			case SEND:
				sendMessage(fromUserId,toUserId, message.getContent());
				break;
			case MESSAGE:
			
				
			default:
				break;
			}
		} catch (Exception e) {
			logger.error("send websocket msg error !!!");
			e.printStackTrace();
		}

	}

}
