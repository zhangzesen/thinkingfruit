package com.thinkingFruit.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkingFruit.client.entity.Agent;
import com.thinkingFruit.client.entity.ClientAddress;
import com.thinkingFruit.client.entity.ClientDepot;
import com.thinkingFruit.client.entity.ClientOrder;
import com.thinkingFruit.client.mapper.AgentDao;
import com.thinkingFruit.client.mapper.ClientOrderDao;
import com.thinkingFruit.client.service.AgentService;
import com.thinkingFruit.client.service.ClientMessageService;
import com.thinkingFruit.client.service.ClientOrderService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.utils.Constant;
import com.ysdevelop.common.utils.OrderNumberGeneratorUtil;

/**
 * @author wulei
 *
 * @date 2018年11月30日
 *
 * @package com.thinkingFruit.client.service.impl
 *
 * @description 仓库订单
 */
@Service
public class ClientOrderServiceImpl implements ClientOrderService {

	@Autowired
	private ClientOrderDao clientOrderDao;
	
	@Autowired
	ClientMessageService messageService;
	
	@Autowired
	private AgentDao agentDao;
	
	@Autowired
	private AgentService agentService;

	/**
	 * 查询仓库列表
	 */
	@Override
	public List<ClientDepot> depotList(Long id) {
		List<ClientDepot> clientDepot = clientOrderDao.findList(id);
		return clientDepot;
	}

	/**
	 * 订单列表
	 */
	@Override
	public List<ClientOrder> orderList(Long id) {
		List<ClientOrder> ClientOrderList = clientOrderDao.findOrderList(id);
		return ClientOrderList;
	}

	/**
	 * 提取信息
	 */
	@Override
	public ClientAddress extractList(Long memberId) {
		ClientAddress ClientAddress = clientOrderDao.extractList(memberId);
		return ClientAddress;
	}

	/**
	 * 提取货物
	 */
	@Override
	public void sendOrder(ClientOrder clientOrder, Long memberId) {
		if (clientOrder == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		//判断信息是否完善
		agentService.checkInformation(memberId);
		String orderNo=OrderNumberGeneratorUtil.get().toString();
		System.out.println("CashCount---->"+clientOrder.getCashCount());
		clientOrder.setOrderNo(orderNo);
		System.out.println("clientOrder--->"+clientOrder.getOrderNo());
		Integer changeCount1 = clientOrderDao.addOrder(clientOrder, memberId);
		Integer changeCount2 = clientOrderDao.updateDepot(clientOrder, memberId);
	
		if (changeCount1 == Constant.DEFALULT_ZERO_INT||changeCount2== Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.DELIVERY_APPLICATION_FAILURE);
		}
		
		Agent agentById = agentDao.getAgentById(memberId);
		String content="代理:"+agentById.getLoginName()+"已申请提货";
		messageService.addMessage(content);
	}

}
