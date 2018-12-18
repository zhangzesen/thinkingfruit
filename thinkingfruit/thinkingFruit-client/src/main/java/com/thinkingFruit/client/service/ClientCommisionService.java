package com.thinkingFruit.client.service;

import java.util.List;

import com.thinkingFruit.client.entity.ClientCommision;

/**
 * @author wulei
 *
 * @date 2018年11月30日
 *
 * @package com.thinkingFruit.client.service
 *
 * @description 佣金列表
 */
public interface ClientCommisionService {
	
	/**
	 * 	获取交易订单列表
	 * @param request
	 * @param purchaseOrderList 交易订单集合
	 */
	List<ClientCommision> ClientCommisionList(Long id);
	/**
	 * 	获取邀请金列表
	 * @param request
	 * @param purchaseOrderList 邀请金集合
	 */
	List<ClientCommision> inviteMoneyList(Long id);
	/**
	 * 	统计个人总佣金
	 * @param request
	 * @param purchaseOrderList 交易订单集合
	 */
	ClientCommision getTotalClientCommision(Long id);
	/**
	 * 统计个人总邀请金
	 * @param request
	 * @param purchaseOrderList 交易订单集合
	 */
	ClientCommision getTotalClientInviteMoney(Long id);
	/**
	 * 获取推广费用
	 * @param request
	 * @param purchaseOrderList 总佣金+总邀请金
	 */
	ClientCommision getTotalCost(Long id);
	
}
