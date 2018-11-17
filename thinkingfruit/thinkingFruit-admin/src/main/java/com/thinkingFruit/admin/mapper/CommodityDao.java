package com.thinkingFruit.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.thinkingFruit.admin.entity.Commodity;
import com.ysdevelop.common.page.Pagination;

public interface CommodityDao {
	
	/**
	 * 	添加商品
	 * @param commodity 商品
	 */
	void addCommodity(Commodity commodity);
	
	/**
	 * 	查询该分类下所有的商品信息
	 * @param queryMap
	 * @param pagination
	 * @return 商品集合
	 */
	List<Commodity> paginationCommodity(@Param("queryMap")Map<String, String> queryMap, @Param("pagination")Pagination<Commodity> pagination);
	
	/**
	 * 	根据规格id查询商品信息
	 * @param id 商品id
	 * @return 商品
	 */
	Commodity findCommodityById(@Param("id")Long id);
	
	/**
	 * 	根据商品id删除商品信息
	 * @param id 商品id
	 */
	void deleteCommodityById(@Param("id") Long id);
	
	/**
	 * 	修改商品表信息
	 * @param commodity 商品
	 */
	void editCommodity(@Param("commodity")Commodity commodity);
	
}
