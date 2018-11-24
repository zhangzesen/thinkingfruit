package com.thinkingFruit.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thinkingFruit.admin.entity.Order;
import com.thinkingFruit.admin.entity.PurchaseOrder;
import com.thinkingFruit.admin.mapper.OrderDao;
import com.thinkingFruit.admin.service.OrderService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.utils.Constant;

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
	 * 	提货订单分页
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
	 * 	获取提货订单详情
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
	 *	 提货订单发货
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void updateOrderStatus(Order order) {
		if(order==null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		Integer updateOrderStatus = orderDao.updateOrderStatus(order);
		if(updateOrderStatus==Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.DELIVER_FAIL);
		}
	}
	
	/**
	 * 	取消提货订单
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void cancalOrder(Order order) {
		if(order==null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		Integer cancelOrder =orderDao.cancelOrder(order.getId());
		if(cancelOrder==Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.CANCEL_FAIL);
		}
	}
	
	/**
	 * 	导出提货订单excel
	 */
	@Transactional(rollbackFor = Exception.class)
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
	
	/**
	 * 交易订单分页
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public PageInfo<PurchaseOrder> paginationPurchaseOrder(Map<String, String> queryMap) {
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
		List<PurchaseOrder> order = orderDao.listPurchase(queryMap);

		PageInfo<PurchaseOrder> pageInfo = new PageInfo<>(order);
		return pageInfo;
	}
	
	/**
	 * 交易订单详情
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public PurchaseOrder findPurchaseOrderById(Long id) {
		if (id == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		PurchaseOrder order = orderDao.getPurchaseOrderById(id);
		return order;
	}
	
	/**
	 * 交易订单发货
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void updatePurchaseOrderStatus(Long id,Long commodityCount) {
		if (id == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		//订单发货
		Integer update=orderDao.updatePurchaseOrderStatus(id);
		System.out.println("update"+update);
		//添加销量
		Integer addSales=orderDao.addSales(id,commodityCount);
		System.out.println("addSales"+addSales);
		if(update==Constant.DEFALULT_ZERO_INT||addSales==Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.DELIVER_FAIL);
		}
	}

	/**
	 * 交易订单取消
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void cancelPurchaseOrderStatus(Long id,Long commodityCount) {
		if (id == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		//取消订单
		Integer update=orderDao.cancelPurchaseOrderStatus(id);
		//减少销量
		Integer reduceSales=orderDao.reduceSales(id,commodityCount);
		if(update==Constant.DEFALULT_ZERO_INT||reduceSales==Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.CANCEL_FAIL);
		}		
	}
	
	/**
	 * 导出交易订单excel
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public List<PurchaseOrder> findPurchaseOrderExcl(Map<String, String> queryMap) {
		if (queryMap == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		//查出订单集合
		List<PurchaseOrder> orders = orderDao.findPurchaseOrderExcl(queryMap);
		return orders;
	}

	@Override
	public List<Order> findUnreceivedOrder() {
		List<Order> orders=orderDao.findUnreceivedOrder();
		return orders;
	}

	@Override
	public void updateBatchByOrders(List<Order> orders) {
		orderDao.updateBatchByOrders(orders);
	}


}
