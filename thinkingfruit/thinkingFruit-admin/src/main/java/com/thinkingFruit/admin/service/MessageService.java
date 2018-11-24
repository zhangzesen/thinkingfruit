package com.thinkingFruit.admin.service;

import java.util.List;
import java.util.Map;

import com.thinkingFruit.admin.entity.Message;
import com.ysdevelop.common.page.Pagination;

public interface MessageService {

	//查询所有的消息
	Pagination<Message> paginationMessage(Pagination<Message> pagination, Map<String, String> queryMap);

	//根据id删除消息
	void deleteMessageById(Long id);

	//批量删除
	void deleteBatch(List<Long> messageIds);

	//添加消息
	void addMessage(String string,Object arg);

}
