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
		
	
	List<ClientCommodity> ClientCommodityList();
	
	
	ClientCommodity findCommodityById(@Param("id")Long id);
	
	
	List<String> findCommodityImagesById(@Param("id")Long id);
	
}
