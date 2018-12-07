package com.thinkingFruit.client.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkingFruit.client.entity.ClientDepot;
import com.thinkingFruit.client.entity.ClientPurchaseOrder;

/**
 * @author zhangzesen
 *
 * @date 2018年11月30日
 *
 * @package com.thinkingFruit.client.mapper
 *
 * @description 交易订单
 */
public interface ClientPurchaseOrderDao {
	
	/**
	 * 	添加交易订单
	 * @param clientPurchaseOrder 交易订单
	 * @return 
	 */
	Integer addPurchaseOrder(ClientPurchaseOrder clientPurchaseOrder);
	
	/**
	 * 	订单列表
	 * @param clientPurchaseOrder 交易订单
	 * @return 
	 */
	List<ClientPurchaseOrder> findList(Long id);
	
	/**
	 * 	向我需求的订单列表
	 * @param clientPurchaseOrder 交易订单
	 * @return 
	 */
	List<ClientPurchaseOrder> findNeedList(Long id);
	
	/**
	 * 	获取仓库
	 * @param agentId 代理id
	 * @param commodityId 商品id
	 * @return 仓库
	 */
	ClientDepot getDepot(@Param("memberId")Long agentId, @Param("commodityId")Long commodityId);
	
	/**
	 *	 修改仓库
	 * @param clientDepot 代理仓库
	 * @return
	 */
	Integer updateDepot(ClientDepot clientDepot);
	
	/**
	 * 	添加仓库
	 * @param clientDepot 代理仓库
	 * @return
	 */
	Integer addDepot(ClientDepot clientDepot);
	
	/**
	 * 	获取下级向上级购买订单 
	 * @param orderNo 代理仓库
	 * @return 订单
	 */
	ClientPurchaseOrder getPurchaseByorderNo(String orderNo);
	
	/**
	 * 	购买订单发货
	 * @param orderStatus 订单状态
	 * @param orderNo 订单号
	 * @return
	 */
	Integer updatePurchaseStatus(@Param("orderStatus")Long orderStatus,@Param("orderNo")String orderNo);
	
	/**
	 * 	取消购买订单
	 * @param orderStatus 订单状态
	 * @param orderNo 订单号
	 * @return
	 */
	Integer cancelPurchaseStatus(@Param("orderStatus")Long orderStatus,@Param("orderNo")String orderNo);
}
