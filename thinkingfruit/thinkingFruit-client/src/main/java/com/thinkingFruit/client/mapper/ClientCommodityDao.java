package com.thinkingFruit.client.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkingFruit.client.entity.ClientCommodity;

/**
 * @author zhangzesen
 *
 * @date 2018年11月26日
 *
 * @package com.thinkingFruit.client.mapper
 *
 * @description 商品
 */
public interface ClientCommodityDao {
		
	/**
	 * 	 查看所有商品
	 * @return 商品集合
	 */
	List<ClientCommodity> ClientCommodityList();
	
	/**
	 * 	商品详情
	 * @param id 商品id
	 * @return 商品
	 */
	ClientCommodity findCommodityById(@Param("id")Long id);
	
	/**
	 * 	通过商品id查询商品详情图
	 * @param id 商品id
	 * @return 商品详情图地址
	 */
	List<String> findCommodityImagesById(@Param("id")Long id);
	
}
