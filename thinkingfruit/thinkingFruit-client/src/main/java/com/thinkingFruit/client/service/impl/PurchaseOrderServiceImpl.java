package com.thinkingFruit.client.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkingFruit.client.entity.Agent;
import com.thinkingFruit.client.entity.ClientPurchaseOrder;
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
		
		clientPurchaseOrder.setCheckStatus(0L);
		
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
	 * 	购买订单完成
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void confirmPurchaseOrder(String orderNo) {
		//通过订单号获取订单
		ClientPurchaseOrder clientPurchaseOrder=clientPurchaseOrderDao.getPurchaseByorderNo(orderNo);
		
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
