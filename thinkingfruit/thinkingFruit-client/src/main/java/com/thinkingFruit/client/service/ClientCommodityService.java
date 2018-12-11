package com.thinkingFruit.client.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	/**
	 * 	查看所有商品
	 * @return 商品集合
	 */
	List<ClientCommodity> ClientCommodityList();
	
	/**
	 * 	查看商品详情
	 * @param request
	 * @param id 商品id
	 * @return 商品
	 */
	ClientCommodity findCommodityById(HttpServletRequest request, Long id);
	/**
	 * 	查看所有轮播图
	 * @return 轮播图集合
	 */
	List<ClientCommodity> fingImgList();
	
}
