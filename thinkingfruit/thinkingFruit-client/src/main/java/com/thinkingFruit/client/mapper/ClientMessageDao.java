package com.thinkingFruit.client.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author zhangzesen
 *
 * @date 2018年11月24日
 *
 * @package com.thinkingFruit.admin.mapper
 *
 * @description 消息
 */
public interface ClientMessageDao {


	/**
	 * 添加信息
	 * @param content 消息内容
	 */
	void addMessage(@Param(value="content")String content);
	
	/**
	 * 批量添加消息
	 * @param contents 消息内容集合
	 */
	void addMessageList(@Param("contents")List<String> contents);
	

}
