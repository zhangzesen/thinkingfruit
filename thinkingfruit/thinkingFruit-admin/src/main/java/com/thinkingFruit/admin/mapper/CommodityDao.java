package com.thinkingFruit.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.thinkingFruit.admin.entity.Commodity;

/**
 * @author zhangzesen
 *
 * @date 2018年11月26日
 *
 * @package com.thinkingFruit.admin.mapper
 *
 * @description 商品
 */
public interface CommodityDao {
	
	/**
	 * 	添加商品
	 * @param commodity 商品
	 */
	Integer addCommodity(Commodity commodity);
	
	/**
	 * 添加商品详情图
	 * @param detailsImagePath 商品详情图数组
	 * @param id 商品id
	 * @return
	 */
	Integer addCommoditydDetailsImage(@Param("id")Long id,@Param("detailsImagePath")List<String> detailsImagePath);
	
	
	/**
	 * 	查询该分类下所有的商品信息
	 * @param queryMap
	 * @return 商品集合
	 */
	List<Commodity> paginationCommodity(@Param("queryMap")Map<String, String> queryMap);
	
	/**
	 * 	根据规格id查询商品信息
	 * @param id 商品id
	 * @return 商品
	 */
	Commodity findCommodityById(@Param("id")Long id);
	
	/**
	 *	 查询商品图片
	 * @param id 商品id
	 * @return
	 */
	List<String> findCommodityImagesById(@Param("id")Long id);
	
	/**
	 * 	根据商品id删除商品信息
	 * @param id 商品id
	 */
	void deleteCommodityById(@Param("id") Long id);
	
	/**
	 *	 删除商品图片
	 * @param id 商品id
	 * @return 
	 */
	Integer deleteCommodityImagesById(@Param("id") Long id);
	
	
	/**
	 * 	修改商品表信息
	 * @param commodity 商品
	 */
	void editCommodity(Commodity commodity);
	
	/**
	 * 获取所有商品
	 * @return 商品集合
	 */
	List<Commodity> listCommodity();
	
}
