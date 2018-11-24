package com.thinkingFruit.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.thinkingFruit.admin.entity.Message;
import com.ysdevelop.common.page.Pagination;

public interface MessageDao {

	//查询与遍历出所对应的数量
	Integer getCountByQuery(@Param(value="queryMap")Map<String, String> queryMap);

	//查询与遍历出所对应的信息
	List<Message> paginationMessage(@Param(value="queryMap")Map<String, String> queryMap,@Param(value="pagination")Pagination<Message> pagination);

	//根据id删除消息
	void deleteMessageById(@Param(value="id")Long id);

	//批量删除
	void deleteBatch(@Param(value="messageIds")List<Long> messageIds);

	//添加信息
	void addMessage(@Param(value="content")String content);
	

}
