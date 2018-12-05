package com.thinkingFruit.client.mapper;

import java.util.List;

import com.thinkingFruit.client.entity.ClientAddress;
import com.thinkingFruit.client.entity.ClientOrder;

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
public interface ClientOrderDao {
	
//	/**
//	 * 	添加交易订单
//	 * @param clientPurchaseOrder 交易订单
//	 * @return 
//	 */
//	Integer addPurchaseOrder(ClientPurchaseOrder clientPurchaseOrder);
//	/**
//	 * 	订单列表
//	 * @param clientPurchaseOrder 交易订单
//	 * @return 
//	 */
	//查找云仓库列表
	List<ClientOrder> findList(Long id);
	//查找发货订单列表
	List<ClientOrder> findOrderList(Long id);
	//搜索提货信息
	ClientAddress extractList(Long memberId);

}
