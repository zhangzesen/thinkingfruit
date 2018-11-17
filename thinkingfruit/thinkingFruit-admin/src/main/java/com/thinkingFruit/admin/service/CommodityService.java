package com.thinkingFruit.admin.service;

import java.util.Map;

import com.thinkingFruit.admin.entity.Commodity;
import com.ysdevelop.common.page.Pagination;


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
	 * @param pagination
	 * @param queryMap
	 * @return 商品
	 */
	Pagination<Commodity> paginationCommodity(Pagination<Commodity> pagination, Map<String, String> queryMap);
	
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
}
