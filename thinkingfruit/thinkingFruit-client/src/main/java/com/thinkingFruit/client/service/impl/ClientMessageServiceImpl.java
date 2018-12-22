package com.thinkingFruit.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkingFruit.client.key.MessageKey;
import com.thinkingFruit.client.mapper.ClientMessageDao;
import com.thinkingFruit.client.service.ClientMessageService;
import com.ysdevelop.common.redis.RedisService;
/**
 * @author zhangzesen
 *
 * @date 2018年12月22日
 *
 * @package com.thinkingFruit.client.service.impl
 *
 * @description  消息
 */
@Service
public class ClientMessageServiceImpl implements ClientMessageService {

	@Autowired
	private ClientMessageDao messageDao;
	
	@Autowired
	private RedisService redisService;
	
	/**
	 * 添加消息
	 */
	@Override
	public void addMessage(String content, Object arg) {
		messageDao.addMessage(content);
		redisService.set(MessageKey.messageKey, "Message", arg);
	}

	/**
	 * 批量添加消息
	 */
	@Override
	public void addMessageList(List<String> contents, Object arg) {
		messageDao.addMessageList(contents);
		redisService.set(MessageKey.messageKey, "Message", arg);
	}

}
