package com.thinkingFruit.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.thinkingFruit.admin.entity.Message;
import com.ysdevelop.common.page.Pagination;

/**
 * @author zhangzesen
 *
 * @date 2018年11月24日
 *
 * @package com.thinkingFruit.admin.mapper
 *
 * @description 消息
 */
public interface MessageDao {

	/**
	 * 查询与遍历出所对应的数量
	 * @param queryMap
	 * @return
	 */
	Integer getCountByQuery(@Param(value="queryMap")Map<String, String> queryMap);

	/**
	 * 查询与遍历出所对应的信息
	 * @param queryMap
	 * @param pagination
	 * @return 消息集合
	 */
	List<Message> paginationMessage(@Param(value="queryMap")Map<String, String> queryMap,@Param(value="pagination")Pagination<Message> pagination);

	/**
	 * 根据id删除消息
	 * @param id 消息id
	 */
	void deleteMessageById(@Param(value="id")Long id);

	/**
	 * 批量删除
	 * @param messageIds 消息id集合
	 */
	void deleteBatch(@Param(value="messageIds")List<Long> messageIds);

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
