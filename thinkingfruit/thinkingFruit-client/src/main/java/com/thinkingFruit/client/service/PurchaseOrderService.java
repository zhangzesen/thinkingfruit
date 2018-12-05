package com.thinkingFruit.client.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.thinkingFruit.client.entity.ClientPurchaseOrder;

/**
 * @author zhangzesen
 *
 * @date 2018年11月30日
 *
 * @package com.thinkingFruit.client.service
 *
 * @description 交易订单
 */
public interface PurchaseOrderService {
	
	/**
	 * 	添加交易订单
	 * @param request
	 * @param clientPurchaseOrder 交易订单
	 */
	void addPurchaseOrder(HttpServletRequest request, ClientPurchaseOrder clientPurchaseOrder);
	/**
	 * 	获取交易订单列表
	 * @param request
	 * @param purchaseOrderList 交易订单集合
	 */
	List<ClientPurchaseOrder> purchaseOrderList(Long id);
	
}
