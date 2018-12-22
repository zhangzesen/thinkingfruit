package com.thinkingFruit.client.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkingFruit.client.entity.ClientAddress;
import com.thinkingFruit.client.entity.ClientDepot;
import com.thinkingFruit.client.entity.ClientOrder;

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
public interface ClientOrderDao {

	// 查找云仓库列表
	List<ClientDepot> findList(Long id);

	// 查找发货订单列表
	List<ClientOrder> findOrderList(Long id);

	// 搜索提货信息
	ClientAddress extractList(Long memberId);


	// 更新云仓库余额
	Integer updateDepot(@Param("ClientOrder")ClientOrder clientOrder,@Param("memberId")Long memberId);
    //添加订单
	Integer addOrder(@Param("ClientOrder")ClientOrder clientOrder,@Param("memberId")Long memberId);
}
