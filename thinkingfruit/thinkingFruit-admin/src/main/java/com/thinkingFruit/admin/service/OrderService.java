package com.thinkingFruit.admin.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.thinkingFruit.admin.entity.Order;
import com.thinkingFruit.admin.entity.PurchaseOrder;

/**
 * @author zhangzesen
 *
 * @date 2018年11月21日
 *
 * @package com.thinkingFruit.admin.service
 *
 * @description 订单
 */
public interface OrderService {
	
	/**
	 * 	获取提货订单分页
	 * @param queryMap
	 * @return 订单
	 */
	PageInfo<Order> paginationOrder(Map<String, String> queryMap);
	
	/**
	 * 	获取提货订单详情
	 * @param id 订单id
	 * @return 订单
	 */
	Order findOrderById(Long id);
	
	/**
	 * 	提货订单发货
	 * @param order 订单
	 */
	void updateOrderStatus(Order order);
	
	/**
	 * 	取消提货订单
	 * @param order 订单
	 */
	void cancalOrder(Order order);
	
	/**
	 *	 查出要导出提货excel的信息
	 * @param queryMap
	 * @return 订单集合
	 */
	List<Order> findOrderExcl(Map<String, String> queryMap);
	
	/**
	 * 获取交易订单分页
	 * @param queryMap
	 * @return 交易订单集合
	 */
	PageInfo<PurchaseOrder> paginationPurchaseOrder(Map<String, String> queryMap);
	
	/**
	 * 获取交易订单详情
	 * @param id 交易订单id
	 * @return
	 */
	PurchaseOrder findPurchaseOrderById(Long id);
	
	/**
	 * 交易订单发货
	 * @param id 交易订单id
	 */
	void updatePurchaseOrderStatus(Long id,Long commodityCount);
	
	/**
	 * 交易订单取消
	 * @param id 交易订单id
	 */
	void cancelPurchaseOrderStatus(Long id,Long commodityCount);
	
	/**
	 * 获取excel所需交易订单
	 * @param queryMap
	 * @return 交易订单集合
	 */
	List<PurchaseOrder> findPurchaseOrderExcl(Map<String, String> queryMap);
	
	/**
	 * 获取所有待收货订单
	 * @return 待收货订单集合
	 */
	List<Order> findUnreceivedOrder();
	
	/**
	 * 修改所有待收货订单为已收货
	 * @param orders 待收货订单集合
	 */
	void updateBatchByOrders(List<Order> orders);
	
	/**
	 * 往代理仓库添加商品库存，生成交易订单
	 * @param purchaseOrder 交易订单
	 */
	void examineUpdate(PurchaseOrder purchaseOrder);

	/**
	 * 往代理仓库添加商品库存，生成升级交易订单
	 * @param purchaseOrder 交易订单
	 */
	void upExamineUpdate(PurchaseOrder purchaseOrder);

}
