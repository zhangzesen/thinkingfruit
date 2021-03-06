package com.thinkingFruit.admin.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thinkingFruit.admin.entity.Commodity;
import com.thinkingFruit.admin.mapper.CommodityDao;
import com.thinkingFruit.admin.service.CommodityService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.utils.Constant;
/**
 * @author zhangzesen
 *
 * @date 2018年11月17日
 *
 * @package com.thinkingFruit.admin.service.impl
 *
 * @description 商品
 */
@Service
public class CommodityServiceImpl implements CommodityService {
	
	@Autowired
	CommodityDao commodityDao;
	
	
	/**
	 * 	查看所有商品
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public PageInfo<Commodity> paginationCommodity(Map<String, String> queryMap) {
		
		if (queryMap == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		// 获取分页条件的
		String pageSize = queryMap.get("limit");
		String pageNum = queryMap.get("page");
		System.out.println("pageSize"+pageSize);
		System.out.println("pageNum"+pageNum);
		String name = queryMap.get("name");
		System.out.println("name:"+name);
		if (pageSize == null || pageNum == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		Integer integerPageSize = Integer.parseInt(pageSize);
		Integer integerPageNum = Integer.parseInt(pageNum);
		// 调用存储过程实现树形分类
		
		PageHelper.startPage(integerPageNum, integerPageSize, Boolean.TRUE);
		List<Commodity> commodity = commodityDao.paginationCommodity(queryMap);
		
		
		PageInfo<Commodity> pageInfo = new PageInfo<>(commodity);
		return pageInfo;
	}
	
	/**
	 * 	添加商品
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void addCommodity(Commodity commodity) {
		if(commodity==null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		//添加商品
		Integer addCommodity = commodityDao.addCommodity(commodity);
		if(addCommodity==Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.COMMODITYNAME_ERROR);
		}
		Long id = commodity.getId();
		//获取从ajax传过来的图片路径，从json数据转为list
		commodity.setDetailsImagePaths(JSON.parseArray(commodity.getDetailsImagePath(), String.class));

		List<String> detailsImagePath = commodity.getDetailsImagePaths();
		List<Commodity> commoditys=new ArrayList<>();
		//将图片set进商品实体类
		for(int i=0;i<detailsImagePath.size();i++) {
				Commodity comm=new Commodity();
				comm.setDetailsImagePath(detailsImagePath.get(i));
				comm.setId(id);
				commoditys.add(comm);
		}
		//添加商品详情图
		Integer addCommoditydDetailsImage = commodityDao.addCommodityDetailsImage(commoditys);
		if(addCommoditydDetailsImage==Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.COMMODITYNAME_ERROR);
		}
		
	}
	
	/**
	 *	 删除商品
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void deleteCommodityById(Long id) {
		if(id==null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		//删除商品
		commodityDao.deleteCommodityById(id);
		//删除商品图片
		commodityDao.deleteCommodityImagesById(id);
	}
	
	/**
	 * 	查询商品详情 
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Commodity findCommodityById(Long id) {
		System.out.println(id);
		//获取商品
		Commodity findCommodityById = commodityDao.findCommodityById(id);
		//获取商品详情图
		List<String> findCommodityImagesById = commodityDao.findCommodityImagesById(id);
		findCommodityById.setDetailsImagePaths(findCommodityImagesById);
		return findCommodityById;
	}
	
	/**
	 * 	修改商品
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void editCommodity(Commodity commodity) {
		if(commodity==null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		//修改商品
		commodityDao.editCommodity(commodity);
		Long id = commodity.getId();
		//先删除商品图片
		Integer deleteCommodityImagesById = commodityDao.deleteCommodityImagesById(id);
		if(deleteCommodityImagesById==Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.COMMODITYNAME_UPDATE_ERROR);
		}
		//再从js获取商品图片
		commodity.setDetailsImagePaths(JSON.parseArray(commodity.getDetailsImagePath(), String.class));
		List<String> detailsImagePath = commodity.getDetailsImagePaths();
		List<Commodity> commoditys=new ArrayList<>();
		System.out.println("zz:"+detailsImagePath.size());
		
		for(int i=0;i<detailsImagePath.size();i++) {
				commodity.setDetailsImagePath(detailsImagePath.get(i));
				commodity.setId(id);
				commoditys.add(commodity);
		}
		commodityDao.editCommodity(commodity);
		//添加商品详情图
		Integer addCommoditydDetailsImage = commodityDao.addCommodityDetailsImage(commoditys);
		if(addCommoditydDetailsImage==Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.COMMODITYNAME_UPDATE_ERROR);
		}
	}
	
	/**
	 *  获取所有商品
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public List<Commodity> listCommodity() {
		List<Commodity> listCommodity=commodityDao.listCommodity();
		return listCommodity;
	}
	
}
