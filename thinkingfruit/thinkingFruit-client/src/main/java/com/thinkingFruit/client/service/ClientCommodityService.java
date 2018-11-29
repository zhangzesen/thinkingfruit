package com.thinkingFruit.client.service;

import java.util.List;

import com.thinkingFruit.client.entity.ClientCommodity;


/**
 * @author zhangzesen
 *
 * @date 2018年11月17日
 *
 * @package com.thinkingFruit.client.service
 *
 * @description 商品
 */
public interface ClientCommodityService {
	

	List<ClientCommodity> ClientCommodityList();
	
	
	ClientCommodity findCommodityById(Long id);
	
}
