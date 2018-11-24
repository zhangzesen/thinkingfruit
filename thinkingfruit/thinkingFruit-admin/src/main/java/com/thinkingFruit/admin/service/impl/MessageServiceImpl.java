package com.thinkingFruit.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkingFruit.admin.entity.Message;
import com.thinkingFruit.admin.key.MessageKey;
import com.thinkingFruit.admin.mapper.MessageDao;
import com.thinkingFruit.admin.service.MessageService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.redis.RedisService;
import com.ysdevelop.common.result.CodeMsg;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	MessageDao messageDao;
	
	@Autowired
	private RedisService redisService;
	
	@Override
	public Pagination<Message> paginationMessage(Pagination<Message> pagination, Map<String, String> queryMap) {
		Integer page = null;
		Integer limit = null;
		if (queryMap == null || (page = Integer.valueOf(queryMap.get("page"))) == null || (limit = Integer.valueOf(queryMap.get("limit"))) == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		pagination.setPageNum(page);
		pagination.setPageSize(limit);	
		
		Integer totalItemsCount = messageDao.getCountByQuery(queryMap);
		List<Message> messageItems = messageDao.paginationMessage(queryMap, pagination);
		
		pagination.setItems(messageItems);
		pagination.setTotalItemsCount(totalItemsCount);
		
		return pagination;
	}

	@Override
	public void deleteMessageById(Long id) {
		messageDao.deleteMessageById(id);
	}

	@Override
	public void deleteBatch(List<Long> messageIds) {
		messageDao.deleteBatch(messageIds);
	}

	@Override
	public void addMessage(String content,Object arg) {
		messageDao.addMessage(content);
		redisService.set(MessageKey.messageKey, "Message", arg);
	}




}
