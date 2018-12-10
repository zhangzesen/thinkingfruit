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
				
		
				
		//生成订单号
		String orderNo=OrderNumberGeneratorUtil.get().toString();
		System.out.println("orderNo"+orderNo);
		//将代理信息set进交易订单中
		clientPurchaseOrder.setOrderNo(orderNo);
		clientPurchaseOrder.setOrderMemberName(agentById.getLoginName());
		clientPurchaseOrder.setOrderMemberId(agentById.getId());
		clientPurchaseOrder.setMemberLevel(agentById.getMemberLevelId());
		clientPurchaseOrder.setIsFirst(1L);
		//添加交易订单
		Integer addPurchaseOrder = clientPurchaseOrderDao.addPurchaseOrder(clientPurchaseOrder);
		if(addPurchaseOrder==Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.PURCHASE_FAIL);
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
	public void confirmPurchaseOrder(HttpServletRequest request,String orderNo) {
		ClientPurchaseOrder clientPurchaseOrder=clientPurchaseOrderDao.getPurchaseByorderNo(orderNo);
		//通过代理id获取代理信息
		HttpSession session = request.getSession();
		agentId=(Long) session.getAttribute("agentId");
		System.out.println("agentId"+agentId);
		Agent agentById = agentDao.getAgentById(agentId);
		
		//判断上级商品库存是否充足，如果是公司则默认无限
		if(agentById.getInviterId()!=Constant.DEFALULT_ZERO_INT) {
		//判断上级库存是否充足,充足则需要减少库存
		ClientDepot Depot=clientPurchaseOrderDao.getDepot(agentById.getInviterId(),clientPurchaseOrder.getCommodityId());
		if(Depot!=null&&Depot.getId()!=null) {
			if(Depot.getCount()-clientPurchaseOrder.getCommodityCount()>=0) {
				Depot.setMemberId(agentById.getInviterId());
				Depot.setCommodityId(clientPurchaseOrder.getCommodityId());
				Depot.setCount(Depot.getCount()-clientPurchaseOrder.getCommodityCount());
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
						
		//判断订单创建者的上级和上上级的关系
		Long inviterId = agentById.getInviterId();
		Long inviterUpperId = agentById.getInviterUpperId();
		Long memberLevelId = agentById.getMemberLevelId();
		Agent inviterById = agentDao.getAgentById(inviterId);
		Long inviterLevelId = inviterById.getMemberLevelId();
		//如果上上级级别比上级级别高或者平级
		CommissionRatio commissionRatio=agentDao.getAgentLevel(agentById.getMemberLevelId());
		ClientCommision clientCommision=new ClientCommision();
		
		//上级如果是公司
		if(inviterId==Constant.DEFALULT_ZERO_INT) {
			clientCommision.setCommisionProportion(0.0);
			clientCommision.setCommision(0.0);
		}else {
			if(memberLevelId>inviterLevelId) {
				clientCommision.setCommisionProportion(commissionRatio.getCrossLevelDiscount());
			}else if(memberLevelId==inviterLevelId) {
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
		Integer updatePurchaseStatus=clientPurchaseOrderDao.updatePurchaseStatus((long) Constant.DEFALULT_TWO_INT,orderNo);
		if(addClientCommision==Constant.DEFALULT_ZERO_INT||updatePurchaseStatus==Constant.DEFALULT_ZERO_INT) {
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
