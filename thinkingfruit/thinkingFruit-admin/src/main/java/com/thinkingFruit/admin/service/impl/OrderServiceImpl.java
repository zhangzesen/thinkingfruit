package com.thinkingFruit.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thinkingFruit.admin.entity.Order;
import com.thinkingFruit.admin.mapper.OrderDao;
import com.thinkingFruit.admin.service.OrderService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;

/**
 * @author zhangzesen
 *
 * @date 2018年11月21日
 *
 * @package com.thinkingFruit.admin.service.impl
 *
 * @description 订单
 */
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDao orderDao;
	
	/**
	 * 	订单分页
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public PageInfo<Order> paginationOrder(Map<String, String> queryMap) {
		if (queryMap == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		// 获取分页条件的
		String pageSize = queryMap.get("limit");
		String pageNum = queryMap.get("page");
		if (pageSize == null || pageNum == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		Integer integerPageSize = Integer.parseInt(pageSize);
		Integer integerPageNum = Integer.parseInt(pageNum);
		PageHelper.startPage(integerPageNum, integerPageSize, Boolean.TRUE);
		//获取订单集合
		List<Order> order = orderDao.list(queryMap);

		PageInfo<Order> pageInfo = new PageInfo<>(order);
		return pageInfo;
	}
	
	/**
	 * 	获取订单详情
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Order findOrderById(Long id) {
		if (id == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		Order order = orderDao.getById(id);
		return order;
	}
	
	/**
	 *	 发货
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void updateOrderStatus(Order order) {
		if(order==null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		Integer updateOrderStatus = orderDao.updateOrderStatus(order);
		if(updateOrderStatus==0) {
			throw new WebServiceException(CodeMsg.DELIVER_FAIL);
		}
	}
	
	/**
	 * 	取消订单
	 */
	@Override
	public void cancalOrder(Order order) {
		if(order==null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		Integer cancelOrder =orderDao.cancelOrder(order.getId());
		if(cancelOrder==0) {
			throw new WebServiceException(CodeMsg.CANCEL_FAIL);
		}
	}
	
	/**
	 * 	导出excel
	 */
	@Override
	public List<Order> findOrderExcl(Map<String, String> queryMap) {
		if (queryMap == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		//查出订单集合
		List<Order> orders = orderDao.findOrderExcl(queryMap);
		for (Order order : orders) {
			order.setAllAddress(order.getProvince()+order.getCity()+order.getDiatrict()+order.getAddress());
		}
		return orders;
	}


}
