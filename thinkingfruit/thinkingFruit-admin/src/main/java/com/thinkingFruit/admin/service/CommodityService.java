package com.thinkingFruit.admin.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.thinkingFruit.admin.entity.Commodity;


/**
 * @author zhangzesen
 *
 * @date 2018年11月17日
 *
 * @package com.thinkingFruit.admin.service
 *
 * @description 商品
 */
public interface CommodityService {
	
	/**
	 * 	添加商品
	 * @param commodity 商品
	 */
	void addCommodity(Commodity commodity);

	/**
	 * 	查询所有的商品信息
	 * @param queryMap
	 * @return 商品
	 */
	PageInfo<Commodity> paginationCommodity(Map<String, String> queryMap);
	
	/**
	 *	 根据商品id删除商品信息
	 * @param id 商品id
	 */
	void deleteCommodityById(Long id);
	
	/**
	 * 	根据id查询商品信息
	 * @param id 商品id
	 * @return 商品
	 */
	Commodity findCommodityById(Long id);
	
	/**
	 * 	修改商品信息
	 * @param commodity 商品
	 */
	void editCommodity(Commodity commodity);
	
	/**
	 * 获取所有商品
	 * @return 商品集合
	 */
	List<Commodity> listCommodity();
}
