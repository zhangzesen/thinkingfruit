package com.ysdevelop.admin.service.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.admin.service.WebsocketMessageService;
import com.ysdevelop.mq.observer.MessageObserver;
import com.ysdevelop.mq.server.WebsocketMessageConsume;
@Service
public class WebsocketMessageServiceImpl implements WebsocketMessageService,MessageObserver,InitializingBean {

	@Autowired
	private WebsocketMessageConsume websocketMessageConsume;
	
	@Override
	public void getMessage() {
			
	}

	@Override
	public void updateMessage(String message) {
		System.out.println(message);
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("websocket consume :"+websocketMessageConsume);
		websocketMessageConsume.addObserver(this);
		
	}

}
