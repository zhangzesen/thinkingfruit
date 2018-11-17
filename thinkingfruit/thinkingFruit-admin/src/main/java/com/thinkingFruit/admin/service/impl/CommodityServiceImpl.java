package com.thinkingFruit.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkingFruit.admin.entity.Commodity;
import com.thinkingFruit.admin.mapper.CommodityDao;
import com.thinkingFruit.admin.service.CommodityService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.CodeMsg;
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
	@Override
	public Pagination<Commodity> paginationCommodity(Pagination<Commodity> pagination, Map<String, String> queryMap) {
		Integer page = null;
		Integer limit = null;
		if (queryMap == null || (page = Integer.valueOf(queryMap.get("page"))) == null || (limit = Integer.valueOf(queryMap.get("limit"))) == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		pagination.setPageNum(page);
		pagination.setPageSize(limit);
		List<Commodity> commodityItems = commodityDao.paginationCommodity(queryMap, pagination);
		pagination.setItems(commodityItems);
		return pagination;
	}
	
	/**
	 * 	添加商品
	 */
	@Override
	public void addCommodity(Commodity commodity) {
		commodityDao.addCommodity(commodity);
	}
	
	/**
	 *	 删除商品
	 */
	@Override
	public void deleteCommodityById(Long id) {
		commodityDao.deleteCommodityById(id);
	}
	
	/**
	 * 	查询商品详情 
	 */
	@Override
	public Commodity findCommodityById(Long id) {
		Commodity findCommodityById = commodityDao.findCommodityById(id);
		return findCommodityById;
	}
	
	/**
	 * 	修改商品
	 */
	@Override
	public void editCommodity(Commodity commodity) {
		commodityDao.editCommodity(commodity);
	}

}
