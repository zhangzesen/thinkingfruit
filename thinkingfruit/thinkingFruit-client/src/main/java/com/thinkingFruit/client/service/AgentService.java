package com.thinkingFruit.client.service;

import java.util.Map;

import com.thinkingFruit.client.entity.Agent;


/**
 * @author zhangzesen
 *
 * @date 2018年11月27日
 *
 * @package com.ysdevelop.shiro.service
 *
 * @description 代理
 */
public interface AgentService {
	/** 向数据库中添加一条用户数据 **/
	void addAgent(Agent agent);

	/** 通过指定的name字段查询用户详细信息 **/
	Agent getAgentByName(String name);

	/** 通过指定的id字段查询用户详细信息 **/
	Agent getAgentById(Long id);

	/** 检查用户名是否已被注册 **/
	void checkName(Map<String, String> queryMap);
}
