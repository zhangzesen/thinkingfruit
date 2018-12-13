package com.thinkingFruit.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkingFruit.client.entity.ClientCommision;
import com.thinkingFruit.client.mapper.ClientCommisionDao;
import com.thinkingFruit.client.service.ClientCommisionService;
/**
 * @author wulei
 *
 * @date 2018年11月30日
 *
 * @package com.thinkingFruit.client.service.impl
 *
 * @description 交易订单
 */
@Service
public class ClientCommisionServiceImpl implements ClientCommisionService {
	
	@Autowired
	private ClientCommisionDao ClientCommisionDao;
    /**
     * 订单列表
     * */
	@Override
	public List<ClientCommision> ClientCommisionList(Long id) {
		List<ClientCommision> ClientCommisionList = ClientCommisionDao.findCommisionList(id);
		System.out.println("ClientCommisionList--->"+ClientCommisionList);
		return ClientCommisionList;
	}
	/**
	 * 获取总佣金
	 */
	@Override
	public ClientCommision getTotalClientCommision(Long id) {
		ClientCommision ClientCommision=ClientCommisionDao.getTotalClientCommision(id);
		return ClientCommision;
	}
	/**
	 * 获取总邀请金
	 */
	@Override
	public ClientCommision getTotalClientInviteMoney(Long id) {
		ClientCommision ClientCommision=ClientCommisionDao.getTotalClientInviteMoney(id);
		return ClientCommision;
	}
	/**
	 * 获取邀请金列表
	 */
	@Override
	public List<ClientCommision> inviteMoneyList(Long id) {
		List<ClientCommision> ClientCommisionList = ClientCommisionDao.findInviteMoney(id);
		return ClientCommisionList;
	}


}
