package com.thinkingFruit.client.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkingFruit.client.entity.Agent;
import com.thinkingFruit.client.entity.CommissionRatio;


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
	 * @return 
	 */
	Integer addAgent(Agent agent);

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
     * 查询邀请人
     * @param id 代理id
     * @return 邀请人
     */
	Agent findinvite(Long id);
	/**
	 * 获取代理团队人数
	 * @param id 代理id
	 * @return 团队人数
	 */
	Long getTeamNumbers(Long id);
	/**
	 * 获取团队总销售额
	 * @param id 代理id
	 * @return 总销售额
	 */
	Double getTeamSales(Long id);
	
	/**
	 * 添加地址
	 * @param id 代理id
	 * @return
	 */
	Integer addAgentAddress(@Param("id")Long id);
	
	/**
	 * 获取代理地址
	 * @param memberId 代理id
	 * @return 代理信息
	 */
	Agent getAgentAddress(@Param("memberId")Long memberId);
	
	/**
	 * 修改代理地址
	 * @param agent 代理信息
	 * @return
	 */
	Integer updateAgentAddress(Agent agent);

	CommissionRatio getAgentLevel(Long memberLevelId);
/**
 * 查出头部信息
 * @param id
 * @return
 */
	Agent findInfo(Long id);
}
