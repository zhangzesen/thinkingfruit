package com.thinkingFruit.client.service;

import java.util.List;

/**
 * @author zhangzesen
 *
 * @date 2018年11月24日
 *
 * @package com.thinkingFruit.admin.service
 *
 * @description 消息
 */
public interface ClientMessageService {


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
