package com.thinkingFruit.client.service;

import java.util.List;

import com.thinkingFruit.client.entity.ClientAddress;
import com.thinkingFruit.client.entity.ClientDepot;
import com.thinkingFruit.client.entity.ClientOrder;

/**
 * @author wulei
 *
 * @date 2018年11月30日
 *
 * @package com.thinkingFruit.client.service
 *
 * @description 云仓库订单
 */
public interface ClientOrderService {
	
	/**
	 * 	添加交易订单
	 * @param request
	 * @param clientOrder 交易订单
	 */
	//void addPurchaseOrder(HttpServletRequest request, ClientPurchaseOrder clientPurchaseOrder);
	/**
	 * 	
	 * @param request
	 * @param List云仓库列表
	 */
	List<ClientDepot> depotList(Long id);
	/**
	 * 	
	 * @param request
	 * @param 订单列表
	 */
	List<ClientOrder> orderList(Long id);
	/**
	 * 	
	 * @param request
	 * @param 提货信息
	 */
	ClientAddress extractList(Long memberId);
	/**
	 * 	
	 * @param request
	 * @param 确认提取货物
	 */
	void sendOrder(ClientOrder clientOrder, Long memberId);
	
}
