package com.thinkingFruit.client.mapper;

import java.util.List;

import com.thinkingFruit.client.entity.ClientPurchaseOrder;

/**
 * @author zhangzesen
 *
 * @date 2018年11月30日
 *
 * @package com.thinkingFruit.client.mapper
 *
 * @description 交易订单
 */
public interface ClientPurchaseOrderDao {
	
	/**
	 * 	添加交易订单
	 * @param clientPurchaseOrder 交易订单
	 * @return 
	 */
	Integer addPurchaseOrder(ClientPurchaseOrder clientPurchaseOrder);
	/**
	 * 	订单列表
	 * @param clientPurchaseOrder 交易订单
	 * @return 
	 */
	List<ClientPurchaseOrder> findList(Long id);
	/**
	 * 	向我需求的订单列表
	 * @param clientPurchaseOrder 交易订单
	 * @return 
	 */
	List<ClientPurchaseOrder> findNeedList(Long id);

}
