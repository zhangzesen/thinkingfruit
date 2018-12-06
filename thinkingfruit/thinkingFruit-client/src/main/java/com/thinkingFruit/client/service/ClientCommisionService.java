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
	
}
