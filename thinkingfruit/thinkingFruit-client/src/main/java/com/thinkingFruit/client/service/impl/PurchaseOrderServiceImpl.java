package com.thinkingFruit.client.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkingFruit.client.entity.Agent;
import com.thinkingFruit.client.entity.ClientPurchaseOrder;
import com.thinkingFruit.client.mapper.AgentDao;
import com.thinkingFruit.client.mapper.ClientPurchaseOrderDao;
import com.thinkingFruit.client.service.PurchaseOrderService;
import com.ysdevelop.common.utils.OrderNumberGeneratorUtil;
@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
	
	@Autowired
	private AgentDao agentDao;
	
	@Autowired
	private ClientPurchaseOrderDao clientPurchaseOrderDao;

	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void addPurchaseOrder(HttpServletRequest request,ClientPurchaseOrder clientPurchaseOrder) {
		HttpSession session = request.getSession();
		Long agentId=(Long) session.getAttribute("agentId");
		System.out.println("agentId"+agentId);
		Agent agentById = agentDao.getAgentById(agentId);
		
		String orderNo=OrderNumberGeneratorUtil.get().toString();
		System.out.println("orderNo"+orderNo);
		
		clientPurchaseOrder.setOrderNo(orderNo);
		clientPurchaseOrder.setOrderMemberName(agentById.getLoginName());
		clientPurchaseOrder.setOrderMemberId(agentById.getId());
		clientPurchaseOrder.setMemberLevel(agentById.getMemberLevelId());
		clientPurchaseOrder.setIsFirst(1L);
		clientPurchaseOrderDao.addPurchaseOrder(clientPurchaseOrder);
	}

}
