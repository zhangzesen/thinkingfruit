package com.thinkingFruit.admin.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.thinkingFruit.admin.entity.Order;

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
	 * 	获取订单分页
	 * @param queryMap
	 * @return 订单
	 */
	PageInfo<Order> paginationOrder(Map<String, String> queryMap);
	
	/**
	 * 	获取订单详情
	 * @param id 订单id
	 * @return 订单
	 */
	Order findOrderById(Long id);
	
	/**
	 * 	发货
	 * @param order 订单
	 */
	void updateOrderStatus(Order order);
	
	/**
	 * 	取消订单
	 * @param order 订单
	 */
	void cancalOrder(Order order);
	
	/**
	 *	 查出要导出excel的信息
	 * @param queryMap
	 * @return 订单集合
	 */
	List<Order> findOrderExcl(Map<String, String> queryMap);

}
