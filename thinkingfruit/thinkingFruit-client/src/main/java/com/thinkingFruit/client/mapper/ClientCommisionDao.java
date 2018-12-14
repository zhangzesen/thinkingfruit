package com.thinkingFruit.client.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkingFruit.client.entity.ClientCommision;

/**
 * @author wulei
 * 
 *
 * @date 2018年11月30日
 *
 * @package com.thinkingFruit.client.mapper
 *
 * @description 交易订单
 */
public interface ClientCommisionDao {

	//查找发货订单列表
	List<ClientCommision> findCommisionList(Long id);
	//获取邀请金集合
	List<ClientCommision> findInviteMoney(Long id);

	/**
	 * 	添加佣金记录
	 * @param clientCommision 佣金
	 * @return
	 */
	Integer addClientCommision(ClientCommision clientCommision);
	/**
	 * 	获取个人总佣金
	 * @param clientCommision 佣金
	 * @return
	 */
	ClientCommision getTotalClientCommision(@Param("id")Long id);
	/**
	 * 	获取个人总邀请金
	 * @param clientCommision 佣金
	 * @return
	 */
	ClientCommision getTotalClientInviteMoney(@Param("id")Long id);
	
	Integer updateInviterIdCommision(@Param(value="commision")ClientCommision clientCommision);
	
	Integer updateInviterUpperIdCommision(@Param(value="commision")ClientCommision clientCommision);
	
}
