package com.thinkingFruit.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thinkingFruit.admin.entity.Commision;
import com.thinkingFruit.admin.entity.CommissionRatio;
import com.thinkingFruit.admin.entity.Commodity;
import com.thinkingFruit.admin.entity.Depot;
import com.thinkingFruit.admin.entity.Member;
import com.thinkingFruit.admin.entity.Order;
import com.thinkingFruit.admin.entity.PurchaseOrder;
import com.thinkingFruit.admin.mapper.CommisionDao;
import com.thinkingFruit.admin.mapper.CommodityDao;
import com.thinkingFruit.admin.mapper.MemberDao;
import com.thinkingFruit.admin.mapper.OrderDao;
import com.thinkingFruit.admin.mapper.SiteDao;
import com.thinkingFruit.admin.service.OrderService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.utils.Constant;
import com.ysdevelop.common.utils.OrderNumberGeneratorUtil;

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
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	CommodityDao commodityDao;
	
	@Autowired
	SiteDao siteDao;
	
	@Autowired
	CommisionDao commisionDao;
	
	
	
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
			order.setAllAddress(order.getProvince()+order.getCity()+order.getTown()+order.getAddress());
			if(Constant.DEFALULT_ZERO.toString().equals(order.getOrderStatus())) {
				order.setOrderStatus("待发货");
			}else if(Constant.DEFALULT_ONE.toString().equals(order.getOrderStatus())) {
				order.setOrderStatus("待收货");
			}else if(Constant.DEFALULT_TWO.toString().equals(order.getOrderStatus())) {
				order.setOrderStatus("已完成");
			}
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
		PurchaseOrder purchaseOrderById = orderDao.getPurchaseOrderById(id);
		System.out.println("status:"+purchaseOrderById.getOrderStatus());
		if(Constant.DEFALULT_TWO.toString()==purchaseOrderById.getOrderStatus()||Constant.DEFALULT_TWO.toString().equals(purchaseOrderById.getOrderStatus())) {
			throw new WebServiceException(CodeMsg.IS_DELIVERY);
		}
		//订单发货
		Integer update=orderDao.updatePurchaseOrderStatus(id);
		
		//添加销量
		Integer addSales=orderDao.addSales(purchaseOrderById.getCommodityId(),commodityCount);
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
		for (PurchaseOrder order : orders) {
			if(Constant.DEFALULT_ZERO.toString().equals(order.getOrderStatus())) {
				order.setOrderStatus("下级已下单");
			}else if(Constant.DEFALULT_ONE.toString().equals(order.getOrderStatus())) {
				order.setOrderStatus("上级同意订单");
			}
		}
		return orders;
	}
	
	/**
	 * 获取所有待收货订单
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public List<Order> findUnreceivedOrder() {
		List<Order> orders=orderDao.findUnreceivedOrder();
		return orders;
	}
	
	/**
	 * 修改所有待收货订单为已收货
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void updateBatchByOrders(List<Order> orders) {
		orderDao.updateBatchByOrders(orders);
	}
	
	/**
	 *  往代理仓库添加商品库存，生成交易订单
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void examineUpdate(PurchaseOrder purchaseOrder) {
		//表明注册订单
		String isFirst="0";
		Member memberById = memberDao.memberById(purchaseOrder.getOrderMemberId());
		memberById.setMemberLevelId(purchaseOrder.getMemberLevel());
		Member inviterById = memberDao.memberById(memberById.getInviterId());
		Long inviterUpperLevelId = null;
		if(inviterById!=null) {
			
			Member inviterUpperById = memberDao.memberById(inviterById.getInviterId());
			if(inviterUpperById==null||inviterUpperById.getId()==null) {
				inviterUpperLevelId=0L;
			}else {
				inviterUpperLevelId=inviterUpperById.getMemberLevelId();
			}
		}else {
			inviterUpperLevelId=0L;
		}

		purchaseOrder.setOrderMemberName(memberById.getLoginName());
		purchaseOrder.setInviterId(memberById.getInviterId());
		purchaseOrder.setInviterUpperId(memberById.getInviterUpperId());
		//生成订单号
		String orderNo=OrderNumberGeneratorUtil.get().toString();
		purchaseOrder.setOrderNo(orderNo);
		Commodity findCommodityById = commodityDao.findCommodityById(purchaseOrder.getCommodityId());
		purchaseOrder.setCommodityName(findCommodityById.getName());
		
		//通过后台选择的代理级别，给商品价格赋值
		Double price;
		switch (purchaseOrder.getMemberLevel().toString()) {
        case "1":
        	price=findCommodityById.getFirstPrice();
			break;
        case "2":
        	price=findCommodityById.getSecondPrice();
			break;
        case "3":
        	price=findCommodityById.getThirdPrice();
			break;
        case "4":
        	price=findCommodityById.getFourthPrice();
			break;
        case "5":
        	price=findCommodityById.getFifthPrice();
			break;
        default:
        	price=0.0;
			break;
		}
		purchaseOrder.setCommodityPrice(price);
		purchaseOrder.setOrderTotalPrice(price*purchaseOrder.getCommodityCount());
		purchaseOrder.setIsFirst(isFirst);
		
		
		//生成佣金
		Commision commision=new Commision();
		commision.setOrderNo(orderNo);
		commision.setTotalAmount(purchaseOrder.getOrderTotalPrice());
		//自己的id，邀请者id，邀请者上级id
		Long orderMemberId = purchaseOrder.getOrderMemberId();
		Long inviterId = memberById.getInviterId();
		Long inviterUpperId = memberById.getInviterUpperId();
		Long memberLevelId = purchaseOrder.getMemberLevel();
		Long inviterLevelId;
		
		if(inviterId==Constant.DEFALULT_ZERO_INT) {
			inviterLevelId=0L;
			inviterUpperLevelId=0L;
		}else {
			inviterLevelId = inviterById.getMemberLevelId();
			
		}
		
		commision.setOrderNo(orderNo);
		commision.setMemberId(orderMemberId);
		commision.setCommodityId(purchaseOrder.getCommodityId());
		//获取佣金比例
		if(memberLevelId.longValue()>=inviterLevelId.longValue()) {
			System.out.println("memberLevelId"+memberLevelId);
			System.out.println("inviterLevelId"+inviterLevelId);
			if(inviterById!=null) {
				CommissionRatio commissionRatio = siteDao.getById(inviterById.getMemberLevelId());
				if(inviterLevelId.longValue()>inviterUpperLevelId.longValue()) {
					commision.setCommisionProportion(commissionRatio.getCrossLevelDiscount());
				}else if(inviterUpperLevelId.longValue()==inviterLevelId.longValue()) {
					commision.setCommisionProportion(commissionRatio.getLevelingDiscount());
				}
				
			}else{
				System.out.println("inviterById为空");
				commision.setCommisionProportion(0.0);
			}
			commision.setInviterId(inviterId);
			commision.setInviterUpperId(inviterUpperId);
			commision.setCommision(commision.getTotalAmount()*commision.getCommisionProportion());
			commision.setInviterTotalMoney(commision.getTotalAmount()-commision.getCommision());
			commision.setInviteMoney(0.0);
			//插入代理余额
			memberDao.addBalance(inviterId, commision.getInviterTotalMoney());
			memberDao.addBalance(inviterUpperId, commision.getCommision());
			if(inviterId!=Constant.DEFALULT_ZERO_INT) {
				Depot depot=orderDao.getDepot(purchaseOrder.getInviterId(),purchaseOrder.getCommodityId());
				
				//判断上级库存是否充足
				if(depot!=null&&depot.getId()!=null) {
					if(depot.getCount()-purchaseOrder.getCommodityCount()>=0) {
						depot.setMemberId(inviterId);
						depot.setCommodityId(purchaseOrder.getCommodityId());
						depot.setCount(depot.getCount()-purchaseOrder.getCommodityCount());
						//充足则减少邀请者库存
						Integer updateDepot=orderDao.updateDepot(depot);
						if(updateDepot==Constant.DEFALULT_ZERO_INT) {
							throw new WebServiceException(CodeMsg.EXAMINE_FAIL);
						}
					}else {
						throw new WebServiceException(CodeMsg.INVITER_DEPOT_LOW);
					}
				}else {
					throw new WebServiceException(CodeMsg.INVITER_DEPOT_LOW);
				}
			}
			
		}else if(memberLevelId.longValue()<inviterLevelId.longValue()) {
			purchaseOrder.setInviterId(0L);
			purchaseOrder.setInviterUpperId(0L);
			memberById.setInviterId(0L);
			memberById.setInviterUpperId(0L);
			commision.setInviterId(inviterId);
			commision.setInviterUpperId(0L);
			//修改代理邀请人id和邀请人上级id
			Integer updataById = memberDao.updataById(memberById);
			if(updataById==Constant.DEFALULT_ZERO_INT) {
				throw new WebServiceException(CodeMsg.AGENT_TO_COMPANY_FAIL);
			}
			if(inviterById!=null) {
				CommissionRatio commissionRatio = siteDao.getById(inviterById.getMemberLevelId());
				commision.setInviteMoney(commision.getTotalAmount()*commissionRatio.getReverseLevelDiscount());
			}else{
				commision.setInviteMoney(0.0);
			}
			commision.setCommisionProportion(0.0);
			commision.setInviterTotalMoney(0.0);
			commision.setCommision(commision.getTotalAmount()-commision.getInviteMoney());
			memberDao.addBalance(inviterId,commision.getInviteMoney());
		}
		//插入佣金表
		Integer addCommision=commisionDao.addCommision(commision);
		if(addCommision==Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.EXAMINE_FAIL);
		}
		
		
		//生成注册交易订单
		Integer addFirstPurchase=orderDao.addFirstPurchase(purchaseOrder);
		//修改代理为审核通过
		Integer examineUpdate=memberDao.examineUpdate(purchaseOrder.getOrderMemberId(),purchaseOrder.getMemberLevel());
		if (addFirstPurchase == Constant.DEFALULT_ZERO_INT||examineUpdate== Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.EXAMINE_FAIL);
		}
		Integer addCommosionPerson=commisionDao.addCommosionPerson(purchaseOrder.getOrderMemberId());
		Integer addDepot=orderDao.addDepot(purchaseOrder);
		if(addDepot== Constant.DEFALULT_ZERO_INT||addCommosionPerson== Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.DEPOT_FAIL);
		}
		Commision commosionPerson = commisionDao.getCommosionPerson(0L);
		if(commosionPerson==null||commosionPerson.getId()==null) {
			Integer add=commisionDao.addCommosionPerson(0L);
			if(add== Constant.DEFALULT_ZERO_INT) {
				throw new WebServiceException(CodeMsg.DEPOT_FAIL);
			}
		}
		if(purchaseOrder.getInviterId()==Constant.DEFALULT_ZERO_INT) {
			
			//添加销量
			orderDao.addSales(purchaseOrder.getCommodityId(),purchaseOrder.getCommodityCount());
			
		}
		//修改上级佣金
		Integer updateCommision=commisionDao.updateInviterIdCommision(commision);
		//修改上上级佣金
		Integer update=commisionDao.updateInviterUpperIdCommision(commision);
		if(updateCommision==Constant.DEFALULT_ZERO_INT||update==Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.PURCHASE_FAIL);
		}	
			
		
	}

	/**
	 *  往代理仓库添加商品库存，生成交易订单
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void upExamineUpdate(PurchaseOrder purchaseOrder) {
		//表明升级订单
		String isFirst="2";
		Member memberById = memberDao.memberById(purchaseOrder.getOrderMemberId());
		Member inviterById = memberDao.memberById(memberById.getInviterId());
		Long inviterUpperLevelId;
		if(inviterById!=null) {
			
			Member inviterUpperById = memberDao.memberById(inviterById.getInviterId());
			if(inviterUpperById==null||inviterUpperById.getId()==null) {
				inviterUpperLevelId=0L;
			}else {
				inviterUpperLevelId=inviterUpperById.getMemberLevelId();
			}
		}else {
			inviterUpperLevelId=0L;
		}
		purchaseOrder.setOrderMemberName(memberById.getLoginName());
		purchaseOrder.setInviterId(memberById.getInviterId());
		purchaseOrder.setInviterUpperId(memberById.getInviterUpperId());
		//生成订单号
		String orderNo=OrderNumberGeneratorUtil.get().toString();
		purchaseOrder.setOrderNo(orderNo);
		Commodity findCommodityById = commodityDao.findCommodityById(purchaseOrder.getCommodityId());
		purchaseOrder.setCommodityName(findCommodityById.getName());
		
		//通过不同的代理级别给商品价格赋值
		Double price;
		switch (purchaseOrder.getMemberLevel().toString()) {
        case "1":
        	price=findCommodityById.getFirstPrice();
			break;
        case "2":
        	price=findCommodityById.getSecondPrice();
			break;
        case "3":
        	price=findCommodityById.getThirdPrice();
			break;
        case "4":
        	price=findCommodityById.getFourthPrice();
			break;
        case "5":
        	price=findCommodityById.getFifthPrice();
			break;
        default:
        	price=0.0;
			break;
		}
		purchaseOrder.setCommodityPrice(price);
		purchaseOrder.setOrderTotalPrice(price*purchaseOrder.getCommodityCount());
		purchaseOrder.setIsFirst(isFirst);
		//获取佣金/邀请费比例表
		//生成佣金
		Commision commision=new Commision();
		commision.setOrderNo(orderNo);
		commision.setTotalAmount(purchaseOrder.getOrderTotalPrice());
		//自己的id，邀请者id，邀请者上级id
		Long orderMemberId = purchaseOrder.getOrderMemberId();
		Long inviterId = memberById.getInviterId();
		Long inviterUpperId = memberById.getInviterUpperId();
		Long memberLevelId = purchaseOrder.getMemberLevel();
		Long inviterLevelId;
		if(inviterId==Constant.DEFALULT_ZERO_INT) {
			inviterLevelId=0L;
			inviterUpperLevelId=0L;
		}else {
			inviterLevelId = inviterById.getMemberLevelId();
		}
		commision.setOrderNo(orderNo);
		commision.setMemberId(orderMemberId);
		
		commision.setCommodityId(purchaseOrder.getCommodityId());
		//获取佣金比例
		if(memberLevelId>=inviterLevelId) {
			System.out.println("上级级别大于代理注册级别");
			if(inviterById!=null) {
				//获取佣金/邀请费比例表
				CommissionRatio commissionRatio = siteDao.getById(inviterById.getMemberLevelId());
				if(inviterLevelId.longValue()>inviterUpperLevelId.longValue()) {
					commision.setCommisionProportion(commissionRatio.getCrossLevelDiscount());
				}else if(inviterUpperLevelId.longValue()==inviterLevelId.longValue()) {
					commision.setCommisionProportion(commissionRatio.getLevelingDiscount());
				}
				
			}else{
				commision.setCommisionProportion(0.0);
			}
			commision.setInviterId(inviterId);
			commision.setInviterUpperId(inviterUpperId);
			commision.setCommision(commision.getTotalAmount()*commision.getCommisionProportion());
			commision.setInviterTotalMoney(commision.getTotalAmount()-commision.getCommision());
			//插入代理余额
			memberDao.addBalance(inviterId, commision.getInviterTotalMoney());
			memberDao.addBalance(inviterUpperId, commision.getCommision());
			//判断上级库存是否充足
			if(inviterId!=Constant.DEFALULT_ZERO_INT) {
				Depot depot=orderDao.getDepot(purchaseOrder.getInviterId(),purchaseOrder.getCommodityId());
			
				if(depot!=null&&depot.getId()!=null) {
					if(depot.getCount()-purchaseOrder.getCommodityCount()>=0) {
						depot.setMemberId(inviterId);
						depot.setCommodityId(purchaseOrder.getCommodityId());
						depot.setCount(depot.getCount().longValue()-purchaseOrder.getCommodityCount().longValue());
						//充足则减少邀请者库存
						Integer updateDepot=orderDao.updateDepot(depot);
						if(updateDepot==Constant.DEFALULT_ZERO_INT) {
							throw new WebServiceException(CodeMsg.EXAMINE_FAIL);
						}
					}else {
						throw new WebServiceException(CodeMsg.INVITER_DEPOT_LOW);
					}
				}else {
					throw new WebServiceException(CodeMsg.INVITER_DEPOT_LOW);
				}
			}
			commision.setInviteMoney(0.0);
		}else if(memberLevelId.longValue()<inviterLevelId.longValue()) {
			purchaseOrder.setInviterId(0L);
			purchaseOrder.setInviterUpperId(0L);
			memberById.setInviterId(0L);
			memberById.setInviterUpperId(0L);
			commision.setInviterId(inviterId);
			commision.setInviterUpperId(0L);
			//修改代理邀请人id和邀请人上级id
			Integer updataById = memberDao.updataById(memberById);
			if(updataById==Constant.DEFALULT_ZERO_INT) {
				throw new WebServiceException(CodeMsg.AGENT_TO_COMPANY_FAIL);
			}
			commision.setCommisionProportion(0.0);
			commision.setInviteMoney(0.0);
			commision.setCommision(purchaseOrder.getOrderTotalPrice());
			commision.setInviterTotalMoney(0.0);
			memberDao.addBalance(inviterId,commision.getInviteMoney());
		}
		//插入佣金表
		Integer addCommision=commisionDao.addCommision(commision);
		if(addCommision==Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.EXAMINE_FAIL);
		}
		
		
		//生成升级交易订单
		Integer addFirstPurchase=orderDao.addFirstPurchase(purchaseOrder);
		
		Integer examineUpdate=memberDao.upExamineUpdate(purchaseOrder.getOrderMemberId(),purchaseOrder.getMemberLevel());
		if (addFirstPurchase == Constant.DEFALULT_ZERO_INT||examineUpdate== Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.EXAMINE_FAIL);
		}
		Depot depot = orderDao.getDepot(inviterId,purchaseOrder.getCommodityId());
		if(depot!=null&&depot.getId()!=null) {
			depot.setCount(depot.getCount()+purchaseOrder.getCommodityCount());
			System.out.println("Count2:"+depot.getCount());
			Integer updateDepot=orderDao.updateDepot(depot);
			if(updateDepot==Constant.DEFALULT_ZERO_INT) {
				throw new WebServiceException(CodeMsg.PURCHASE_FAIL);
			}
								
		}else {
			//如果没有该商品的库存,则新建一个商品库存
			Integer addDepot=orderDao.addDepot(purchaseOrder);
			if(addDepot== Constant.DEFALULT_ZERO_INT) {
				throw new WebServiceException(CodeMsg.DEPOT_FAIL);
			}
				
		}
		if(purchaseOrder.getInviterId()==Constant.DEFALULT_ZERO_INT) {
			
			//添加销量
			orderDao.addSales(purchaseOrder.getCommodityId(),purchaseOrder.getCommodityCount());
			
		}
		//修改上级佣金
		Integer updateCommision=commisionDao.updateInviterIdCommision(commision);
		//修改上上级佣金
		Integer update=commisionDao.updateInviterUpperIdCommision(commision);
		if(updateCommision==Constant.DEFALULT_ZERO_INT||update==Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.PURCHASE_FAIL);
		}
	}
	
}
