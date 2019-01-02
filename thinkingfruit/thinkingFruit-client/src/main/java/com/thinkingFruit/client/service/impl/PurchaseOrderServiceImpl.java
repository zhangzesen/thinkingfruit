package com.thinkingFruit.client.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkingFruit.client.entity.Agent;
import com.thinkingFruit.client.entity.ClientCommision;
import com.thinkingFruit.client.entity.ClientDepot;
import com.thinkingFruit.client.entity.ClientPurchaseOrder;
import com.thinkingFruit.client.entity.CommissionRatio;
import com.thinkingFruit.client.mapper.AgentDao;
import com.thinkingFruit.client.mapper.ClientCommisionDao;
import com.thinkingFruit.client.mapper.ClientPurchaseOrderDao;
import com.thinkingFruit.client.service.AgentService;
import com.thinkingFruit.client.service.ClientMessageService;
import com.thinkingFruit.client.service.PurchaseOrderService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.utils.Constant;
import com.ysdevelop.common.utils.OrderNumberGeneratorUtil;
/**
 * @author zhangzesen
 *
 * @date 2018年11月30日
 *
 * @package com.thinkingFruit.client.service.impl
 *
 * @description 交易订单
 */
@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
	
	@Autowired
	private AgentDao agentDao;
	
	@Autowired
	private ClientPurchaseOrderDao clientPurchaseOrderDao;
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private ClientCommisionDao clientCommisionDao;
	
	@Autowired
	ClientMessageService messageService;
	
	private static Long agentId;

	/**
	 * 	添加交易订单
	 * @param request
	 * @param clientPurchaseOrder 交易订单
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void addPurchaseOrder(HttpServletRequest request,ClientPurchaseOrder clientPurchaseOrder) {
		//从session域中获取代理id
		HttpSession session = request.getSession();
		agentId=(Long) session.getAttribute("agentId");
		System.out.println("agentId"+agentId);
		//判断信息是否完善
		agentService.checkInformation(agentId);
				
		//通过代理id获取代理信息
		Agent agentById = agentDao.getAgentById(agentId);
				
		clientPurchaseOrder.setInviterId(agentById.getInviterId());
		//生成订单号
		String orderNo=OrderNumberGeneratorUtil.get().toString();
		System.out.println("orderNo"+orderNo);
		//将代理信息set进交易订单中
		clientPurchaseOrder.setOrderNo(orderNo);
		clientPurchaseOrder.setOrderMemberName(agentById.getLoginName());
		clientPurchaseOrder.setOrderMemberId(agentById.getId());
		clientPurchaseOrder.setMemberLevel(agentById.getMemberLevelId());
		clientPurchaseOrder.setIsFirst(1L);
		if(agentById.getInviterId()==Constant.DEFALULT_ZERO_INT) {
			clientPurchaseOrder.setCheckStatus(1L);
		}else {
			clientPurchaseOrder.setCheckStatus(0L);
		}
		//添加交易订单
		Integer addPurchaseOrder = clientPurchaseOrderDao.addPurchaseOrder(clientPurchaseOrder);
		if(addPurchaseOrder==Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.PURCHASE_FAIL);
		}
				
		if(agentById.getInviterId()==Constant.DEFALULT_ZERO_INT) {
			String content="直属代理:"+agentById.getLoginName()+"已申请向公司买货";
			messageService.addMessage(content);
		}
	}
	
	/**
	 * 	获取交易订单列表
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public List<ClientPurchaseOrder> purchaseOrderList(Long id) {
       List<ClientPurchaseOrder> purchaseOrder = clientPurchaseOrderDao.findList(id);
       System.out.println("purchaseOrder--->"+purchaseOrder);
       return purchaseOrder;
	}
	
	/**
	 *	 获取需求交易订单列表
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public List<ClientPurchaseOrder> purchaseOrderNeedList(Long id) {
		List<ClientPurchaseOrder> purchaseNeedOrder = clientPurchaseOrderDao.findNeedList(id);
		return purchaseNeedOrder;
	}
	
	/**
	 * 	下级购买订单发货
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void confirmPurchaseOrder(String orderNo) {
		ClientPurchaseOrder clientPurchaseOrder=clientPurchaseOrderDao.getPurchaseByorderNo(orderNo);
		//通过代理id获取代理信息
		//邀请者id
		Long inviterId=clientPurchaseOrder.getInviterId();
		Agent inviterIdById = agentDao.getAgentById(inviterId);
		//邀请者上级
		//邀请者上级id
		Long inviterUpperId = inviterIdById.getInviterId();
		Agent inviterUpperIdById = agentDao.getAgentById(inviterUpperId);
		//订单发起者id
		Long agentId=clientPurchaseOrder.getOrderMemberId();
		Long inviterLevelId =0L;
		Long inviterUpperLevelId =0L;
		//判断上级商品库存是否充足，如果是公司则默认无限
		if(inviterId!=Constant.DEFALULT_ZERO_INT) {
		//判断上级库存是否充足,充足则需要减少库存
		ClientDepot Depot=clientPurchaseOrderDao.getDepot(inviterId,clientPurchaseOrder.getCommodityId());
		if(Depot!=null&&Depot.getId()!=null) {
			if(Depot.getCount()-clientPurchaseOrder.getCommodityCount()>=0) {
				Depot.setMemberId(inviterId);
				Depot.setCommodityId(clientPurchaseOrder.getCommodityId());
				Depot.setCount(Depot.getCount()-clientPurchaseOrder.getCommodityCount());
				System.out.println("Count"+Depot.getCount());
				Integer updateInviterDepot=clientPurchaseOrderDao.updateDepot(Depot);
				if(updateInviterDepot==Constant.DEFALULT_ZERO_INT) {
					throw new WebServiceException(CodeMsg.PURCHASE_FAIL);
				}
			}else {
				throw new WebServiceException(CodeMsg.INVITER_DEPOT_LOW);
			}
		}else {
			throw new WebServiceException(CodeMsg.INVITER_DEPOT_LOW);
		}
			//判断订单创建者的上级和上上级的关系
			if(inviterUpperIdById!=null) {
				inviterLevelId = inviterIdById.getMemberLevelId();
				inviterUpperLevelId = inviterUpperIdById.getMemberLevelId();
			}
							
		}
		
		//判断该代理是否有该商品的仓库
		ClientDepot clientDepot=clientPurchaseOrderDao.getDepot(agentId,clientPurchaseOrder.getCommodityId());
		//如果该商品的库存,只需要改变该数据的库存
		if(clientDepot!=null&&clientDepot.getId()!=null) {
			clientDepot.setCount(clientDepot.getCount()+clientPurchaseOrder.getCommodityCount());
			Integer updateDepot=clientPurchaseOrderDao.updateDepot(clientDepot);
			if(updateDepot==Constant.DEFALULT_ZERO_INT) {
				throw new WebServiceException(CodeMsg.PURCHASE_FAIL);
			}
							
		}else {
			//如果没有该商品的库存,则新建一个商品库存
			clientDepot=new ClientDepot();
			clientDepot.setMemberId(agentId);
			clientDepot.setCommodityId(clientPurchaseOrder.getCommodityId());
			clientDepot.setCount(clientPurchaseOrder.getCommodityCount());
			Integer addDepot=clientPurchaseOrderDao.addDepot(clientDepot);
			if(addDepot==Constant.DEFALULT_ZERO_INT) {
				throw new WebServiceException(CodeMsg.PURCHASE_FAIL);
			}
		}
						
		
		CommissionRatio commissionRatio=agentDao.getAgentLevel(inviterLevelId);
		ClientCommision clientCommision=new ClientCommision();
		
		//上级如果是公司
		if(inviterId==Constant.DEFALULT_ZERO_INT) {
			clientCommision.setCommisionProportion(0.0);
			clientCommision.setCommision(0.0);
		}else {
			if(inviterUpperLevelId<inviterLevelId) {
				clientCommision.setCommisionProportion(commissionRatio.getCrossLevelDiscount());
			}else if(inviterUpperLevelId==inviterLevelId) {
				clientCommision.setCommisionProportion(commissionRatio.getLevelingDiscount());
			}
			clientCommision.setCommision(clientPurchaseOrder.getOrderTotalPrice()*clientCommision.getCommisionProportion());
		}
		clientCommision.setOrderNo(orderNo);
		clientCommision.setTotalAmount(clientPurchaseOrder.getOrderTotalPrice());
		clientCommision.setInviterTotalMoney(clientCommision.getTotalAmount()-clientCommision.getCommision());
		clientCommision.setInviteMoney(0.0);
		clientCommision.setCommodityId(clientPurchaseOrder.getCommodityId());
		clientCommision.setMemberId(agentId);
		clientCommision.setInviterId(inviterId);
		clientCommision.setInviterUpperId(inviterUpperId);
		Integer addClientCommision=clientCommisionDao.addClientCommision(clientCommision);
		if(inviterId!=Constant.DEFALULT_ZERO_INT&&inviterUpperId==Constant.DEFALULT_ZERO_INT) {
			Integer updateBalance=agentDao.addBalance(inviterId,clientCommision.getInviterTotalMoney());
			if(updateBalance==Constant.DEFALULT_ZERO_INT) {
				throw new WebServiceException(CodeMsg.PURCHASE_FAIL);
			}
		}else if(inviterId!=Constant.DEFALULT_ZERO_INT&&inviterUpperId!=Constant.DEFALULT_ZERO_INT){
			Integer updateBalance=agentDao.addBalance(inviterId,clientCommision.getInviterTotalMoney());
			Integer addBalance=agentDao.addBalance(inviterUpperId,clientCommision.getCommision());
				
			if(updateBalance==Constant.DEFALULT_ZERO_INT||addBalance==Constant.DEFALULT_ZERO_INT) {
				throw new WebServiceException(CodeMsg.PURCHASE_FAIL);
			}
		}
		//购买商品增加销售额
		Integer updateSalesVolume=agentDao.updateSalesVolume(clientPurchaseOrder.getOrderTotalPrice(),agentId);
		if(updateSalesVolume==Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.PURCHASE_FAIL);
		}
		Integer updatePurchaseStatus=clientPurchaseOrderDao.updatePurchaseStatus((long) Constant.DEFALULT_TWO_INT,orderNo);
		if(addClientCommision==Constant.DEFALULT_ZERO_INT||updatePurchaseStatus==Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.PURCHASE_FAIL);
		}
		Integer updateCommision=clientCommisionDao.updateInviterIdCommision(clientCommision);
		Integer update=clientCommisionDao.updateInviterUpperIdCommision(clientCommision);
		if(updateCommision==Constant.DEFALULT_ZERO_INT||update==Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.PURCHASE_FAIL);
		}
	}

	/**
	 * 	取消向上级购买订单
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void cancelPurchaseOrder(String orderNo) {
		Integer cancelPurchaseOrder=clientPurchaseOrderDao.cancelPurchaseStatus((long)Constant.DEFALULT_THREE_INT,orderNo);
		if(cancelPurchaseOrder==Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.CANCEL_FAIL);
		}
	}

}
