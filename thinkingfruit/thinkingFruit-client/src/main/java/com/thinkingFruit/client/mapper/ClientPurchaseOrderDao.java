package com.thinkingFruit.client.mapper;

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

}
