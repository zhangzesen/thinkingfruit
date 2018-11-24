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
	/**
	 * 查询所有的消息
	 */
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
	
	/**
	 * 根据id删除消息
	 */
	@Override
	public void deleteMessageById(Long id) {
		messageDao.deleteMessageById(id);
	}
	
	/**
	 * 批量删除
	 */
	@Override
	public void deleteBatch(List<Long> messageIds) {
		messageDao.deleteBatch(messageIds);
	}
	
	/**
	 * 添加消息
	 */
	@Override
	public void addMessage(String content,Object arg) {
		messageDao.addMessage(content);
		redisService.set(MessageKey.messageKey, "Message", arg);
	}




}
