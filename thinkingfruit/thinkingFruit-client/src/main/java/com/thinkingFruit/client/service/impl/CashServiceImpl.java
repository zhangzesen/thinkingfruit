package com.thinkingFruit.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkingFruit.client.entity.Agent;
import com.thinkingFruit.client.entity.Cash;
import com.thinkingFruit.client.entity.ClientMessage;
import com.thinkingFruit.client.mapper.AgentDao;
import com.thinkingFruit.client.mapper.CashDao;
import com.thinkingFruit.client.service.CashService;
import com.thinkingFruit.client.service.ClientMessageService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.utils.Constant;
/**
 * @author zhangzesen
 *
 * @date 2018年12月22日
 *
 * @package com.thinkingFruit.client.service.impl
 *
 * @description 提现
 */
@Service
public class CashServiceImpl implements CashService {
	
	@Autowired
	CashDao cashDao;
	
	@Autowired
	ClientMessageService messageService;
	
	@Autowired
	private AgentDao agentDao;
	
	/**
	 * 提现
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void withdrawal(Cash cash) {
		Integer withdrawal=cashDao.withdrawal(cash);
		Agent agentById = agentDao.getAgentById(cash.getMemberId());
		if (withdrawal == Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.CASH_FAILURE);
		}
		String content="代理:"+agentById.getLoginName()+"已申请提现";
		messageService.addMessage(content,new ClientMessage());
	}
	
	/**
	 * 获取提现记录列表
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public List<Cash> list(Long memberId) {
		List<Cash> cash=cashDao.list(memberId);
		return cash;
	}

}
