package com.thinkingFruit.client.mapper;

import org.apache.ibatis.annotations.Param;

import com.thinkingFruit.client.entity.Agent;


public interface AgentDao {

	/** 插入一条用户数据 **/
	void addAgent(Agent agent);

	/** 通过指定的id字段查询用户详细信息 **/
	Agent getAgentById(@Param("id") Long id);

	/** 通过登录名获取用户 **/
	Agent getAgentByName(@Param("loginName") String loginName);

}
