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
	Integer addCommodity(Commodity commodity);
	
	/**
	 * 添加商品详情图
	 * @param detailsImagePath 商品详情图数组
	 * @param id 商品id
	 * @return
	 */
	Integer addCommoditydDetailsImage(@Param("id")Long id,@Param("detailsImagePath")List<String> detailsImagePath);
	
	/**
	 * 添加商品轮播图
	 * @param previewImagePath 商品轮播图数组
	 * @param id 商品id
	 * @return
	 */
	Integer addCommoditydPreviewImage(@Param("id")Long id,@Param("previewImagePath")List<String> previewImagePath);
	
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
	 *	 查询商品图片
	 * @param id 商品id
	 * @param imageStatus 商品类型，0表示轮播图，1表示详情图
	 * @return
	 */
	List<String> findCommodityImagesById(@Param("id")Long id,@Param("imageStatus")Long imageStatus);
	
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
	void editCommodity(@Param("commodity")Commodity commodity);
	
}
