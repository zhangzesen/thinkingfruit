package com.thinkingFruit.client.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkingFruit.client.entity.Agent;


/**
 * @author zhangzesen
 *
 * @date 2018年11月30日
 *
 * @package com.thinkingFruit.client.mapper
 *
 * @description 代理
 */
public interface AgentDao {

	/**
	 * 	插入一条代理数据
	 * @param agent 代理
	 */
	void addAgent(Agent agent);

	/**
	 * 	通过指定的id字段查询代理详细信息 
	 * @param id 代理id
	 * @return 代理
	 */
	Agent getAgentById(@Param("id") Long id);

	/**
	 *	 通过登录名获取代理详细信息 
	 * @param loginName 登录名
	 * @return 代理
	 */
	Agent getAgentByName(@Param("loginName") String loginName);
	
	/**
	 * 	修改/完善个人信息
	 * @param agent 代理
	 * @return
	 */
	Integer updateInformation(Agent agent);
	/**
	 * 	团队列表
	 * @param list
	 * @return
	 */
	List<Agent> findAgentList(Long id);
     /**
      * 查询上级
      * */
	Agent findinvite(Long id);

}
