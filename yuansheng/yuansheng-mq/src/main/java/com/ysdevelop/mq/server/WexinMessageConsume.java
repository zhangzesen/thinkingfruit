package com.ysdevelop.mq.server;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import com.ysdevelop.mq.observer.MessageObservable;

/**
 * 
 * @author oldHuang
 * 
 * @Package com.ysdevelop.mq.server
 * 
 * @Description weixin消息队列消费者,可以注入此类达到消息的监听
 * 
 * @Date 2018年4月24日
 * 
 * @Version
 * 
 */
public class WexinMessageConsume extends MessageObservable implements MessageListener{

	Logger logger = Logger.getLogger(this.getClass());

	

	@Override
	public void onMessage(Message message) {
		logger.info("notice observer ....");
		hasChange();
		noticeAllObservers(new String(message.getBody()));
		logger.info("notice observer finish ....");
		
	}
}
