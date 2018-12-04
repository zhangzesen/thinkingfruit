package com.thinkingFruit.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.thinkingFruit.admin.entity.Order;
import com.thinkingFruit.admin.entity.PurchaseOrder;


/**
 * @author zhangzesen
 *
 * @date 2018年11月21日
 *
 * @package com.thinkingFruit.admin.mapper
 *
 * @description 订单
 */
public interface OrderDao {
	/**
	 * 
	 * 	获取所有提货订单
	 * 
	 * @param queryMap
	 * 
	 * @return List<Order>返订单列表
	 */
	List<Order> list(@Param(value = "queryMap")Map<String, String> queryMap);
	
	/**
	 * 	查看提货订单详情
	 * @param id 订单id
	 * @return 订单
	 */
	Order getById(@Param(value="id")Long id);

	/**
	 * 	提货订单发货
	 * @param order 订单
	 * @return
	 */
	Integer updateOrderStatus(@Param(value="order")Order order);

	/**
	 * 	取消提货订单
	 * @param id 订单id
	 * @return
	 */
	Integer cancelOrder(@Param(value="id")Long id);
	
	/**
	 * 	查出提货order，导出excel
	 * @param queryMap
	 * @return 订单集合
	 */
	List<Order> findOrderExcl(@Param(value="queryMap")Map<String, String> queryMap);
	
	/**
	 * 交易订单
	 * @param queryMap
	 * @return 交易订单集合
	 */
	List<PurchaseOrder> listPurchase(@Param(value="queryMap")Map<String, String> queryMap);
	
	/**
	 * 获取交易订单详情
	 * @param id 交易订单id
	 * @return
	 */
	PurchaseOrder getPurchaseOrderById(@Param(value="id")Long id);
	
	/**
	 * 给联创交易订单发货
	 * @param id 交易订单id
	 * @return
	 */
	Integer updatePurchaseOrderStatus(@Param(value="id")Long id);
	
	/**
	 * 取消联创交易订单
	 * @param id 交易订单
	 * @return
	 */
	Integer cancelPurchaseOrderStatus(@Param(value="id")Long id);
	
	/**
	 * 获取excel所有的订单
	 * @param queryMap
	 * @return 订单集合
	 */
	List<PurchaseOrder> findPurchaseOrderExcl(@Param(value="queryMap")Map<String, String> queryMap);
	
	/**
	 * 增加销量
	 * @param id 商品id
	 * @param commodityCount 商品数量
	 * @return
	 */
	Integer addSales(@Param(value="id")Long id,@Param(value="commodityCount")Long commodityCount);
	
	/**
	 * 减少销量
	 * @param id 商品id
	 * @param commodityCount 商品数量
	 * @return
	 */
	Integer reduceSales(@Param(value="id")Long id,@Param(value="commodityCount")Long commodityCount);
	
	/**
	 * 获取所有待收货订单
	 * @return 待收货订单集合
	 */
	List<Order> findUnreceivedOrder();
	
	/**
	 * 修改所有待收货订单为已收货
	 * @param orders  待收货订单集合
	 */
	void updateBatchByOrders(@Param("order")List<Order> orders);
	
	/**
	 * 注册生成交易订单
	 * @param purchaseOrder 交易订单
	 * @return
	 */
	Integer addFirstPurchase(PurchaseOrder purchaseOrder);
	
	/**
	 * 往代理仓库添加商品库存
	 * @param purchaseOrder 交易订单
	 * @return
	 */
	Integer addDepot(PurchaseOrder purchaseOrder);
	
}
