package com.thinkingFruit.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkingFruit.client.entity.ClientAddress;
import com.thinkingFruit.client.entity.ClientOrder;
import com.thinkingFruit.client.mapper.ClientOrderDao;
import com.thinkingFruit.client.service.ClientOrderService;
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
public class ClientOrderServiceImpl implements ClientOrderService {
	
	@Autowired
	private ClientOrderDao clientOrderDao;

    /**
     * 查询仓库列表
     * */
	@Override
	public List<ClientOrder> depotList(Long id){
       List<ClientOrder> ClientOrderList = clientOrderDao.findList(id);
		return  ClientOrderList;
	}

    /**
     * 订单列表
     * */
	@Override
	public List<ClientOrder> orderList(Long id) {
		List<ClientOrder> ClientOrderList = clientOrderDao.findOrderList(id);
		return ClientOrderList;
	}

	@Override
	public ClientAddress extractList(Long memberId) {
		ClientAddress ClientAddress=clientOrderDao.extractList(memberId);
		return ClientAddress;
	}

}
