package com.thinkingFruit.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.thinkingFruit.admin.entity.Order;


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
	 * 	获取所有订单
	 * 
	 * @param queryMap
	 * 
	 * @return List<Order>返订单列表
	 */
	List<Order> list(@Param(value = "queryMap")Map<String, String> queryMap);
	
	/**
	 * 	查看订单详情
	 * @param id 订单id
	 * @return 订单
	 */
	Order getById(@Param(value="id")Long id);

	/**
	 * 	发货
	 * @param order 订单
	 * @return
	 */
	Integer updateOrderStatus(@Param(value="order")Order order);

	/**
	 * 	取消订单
	 * @param id 订单id
	 * @return
	 */
	Integer cancelOrder(@Param(value="id")Long id);
	
	/**
	 * 	查出order，导出excel
	 * @param queryMap
	 * @return 订单集合
	 */
	List<Order> findOrderExcl(@Param(value="queryMap")Map<String, String> queryMap);
	
}
