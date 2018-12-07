package com.thinkingFruit.client.mapper;

import java.util.List;

import com.thinkingFruit.client.entity.ClientCommision;

/**
 * @author wulei
 * 
 *
 * @date 2018年11月30日
 *
 * @package com.thinkingFruit.client.mapper
 *
 * @description 交易订单
 */
public interface ClientCommisionDao {

	//查找发货订单列表
	List<ClientCommision> findCommisionList(Long id);

	/**
	 * 	添加佣金记录
	 * @param clientCommision 佣金
	 * @return
	 */
	Integer addClientCommision(ClientCommision clientCommision);
	

}
