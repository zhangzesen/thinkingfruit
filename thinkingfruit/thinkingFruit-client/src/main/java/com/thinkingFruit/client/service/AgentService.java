package com.thinkingFruit.client.service;

import java.util.List;
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
	/**
	 * 	向数据库中添加一条代理数据
	 * @param agent 代理
	 */
	void addAgent(Agent agent);

	/**
	 * 	通过登录名查询代理详细信息
	 * @param name 登录名
	 * @return 代理详细信息
	 */
	Agent getAgentByName(String loginName);

	/**
	 * 	通过代理id查询代理详细信息 
	 * @param id 代理id
	 * @return 代理
	 */
	Agent getAgentById(Long id);

	/**
	 *	 检查登录名是否已被注册
	 * @param queryMap
	 */
	void checkName(Map<String, String> queryMap);
	
	/**
	 *	 检查代理信息是否完善
	 * @param id
	 */
	void checkInformation(Long id);
	
	/**
	 * 	修改/完善个人信息
	 * @param agent 代理
	 */
	void updateInformation(Agent agent);
	/**
	 * 团队列表
	 * @param agent 代理
	 */
	List<Agent> agentList(Long id);
	/**
	 * 寻找邀请人
	 * @param agent 代理
	 */
	Agent getInviter(Long id);
	
	/**
	 * 获取代理地址
	 * @param memberId 代理id
	 * @return 代理信息
	 */
	Agent getAgentAddress(Long memberId);
	
	/**
	 * 修改代理地址
	 * @param agent 代理信息
	 */
	void updateAgentAddress(Agent agent);

	/**
	 * 查出头部信息
	 * @param agent 代理信息
	 */
	Agent findInfo(Long id);

	Agent teamAgent(Long id);
	/**
	 * 改变状态为申请升级
	 * @param agent 
	 */
	void updateUpLevel(Long id);
}
