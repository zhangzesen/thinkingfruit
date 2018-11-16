package com.ysdevelop.mq.server;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @author oldHuang
 *
 * @Package com.ysdevelop.mq.server
 * 
 * @Description 队列生产者
 *
 * @Date 2018年4月24日
 *
 * @Version
 *
 */
@Service
public class MessageProducer {

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void sendMessage(String queueKey, Object object) {
		amqpTemplate.convertAndSend(queueKey, object);
	}

}
