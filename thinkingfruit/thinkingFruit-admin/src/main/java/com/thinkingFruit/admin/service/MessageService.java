package com.thinkingFruit.admin.service;

import java.util.List;
import java.util.Map;

import com.thinkingFruit.admin.entity.Message;
import com.ysdevelop.common.page.Pagination;

/**
 * @author zhangzesen
 *
 * @date 2018年11月24日
 *
 * @package com.thinkingFruit.admin.service
 *
 * @description 消息
 */
public interface MessageService {

	/**
	 * 查询所有的消息
	 * @param pagination
	 * @param queryMap
	 * @return 消息分页
	 */
	Pagination<Message> paginationMessage(Pagination<Message> pagination, Map<String, String> queryMap);

	/**
	 * 根据id删除消息
	 * @param id 消息id
	 */
	void deleteMessageById(Long id);

	/**
	 * 批量删除
	 * @param messageIds 消息id集合
	 */
	void deleteBatch(List<Long> messageIds);

	/**
	 * 添加消息
	 * @param string 消息内容
	 * @param arg
	 */
	void addMessage(String string,Object arg);

	/**
	 * 批量添加消息
	 * @param contents 消息内容集合
	 * @param arg
	 */
	void addMessageList(List<String> contents, Object arg);

}
