package com.thinkingFruit.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thinkingFruit.admin.entity.CommissionRatio;
import com.thinkingFruit.admin.mapper.SiteDao;
import com.thinkingFruit.admin.service.SiteService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.utils.Constant;

/**
 * @author zhangzesen
 *
 * @date 2018年11月23日
 *
 * @package com.thinkingFruit.admin.service.impl
 *
 * @description 设置：分佣/邀请比例设置
 */
@Service
public class SiteServiceImpl implements SiteService {

	@Autowired
	SiteDao siteDao;
	
	/**
	 * 分佣/邀请比例分页
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public PageInfo<CommissionRatio> paginationOrder(Map<String, String> queryMap) {
		if (queryMap == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		// 获取分页条件的
		String pageSize = queryMap.get("limit");
		String pageNum = queryMap.get("page");
		if (pageSize == null || pageNum == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		Integer integerPageSize = Integer.parseInt(pageSize);
		Integer integerPageNum = Integer.parseInt(pageNum);
		PageHelper.startPage(integerPageNum, integerPageSize, Boolean.TRUE);
		//获取订单集合
		List<CommissionRatio> commissionRatio = siteDao.list(queryMap);

		PageInfo<CommissionRatio> pageInfo = new PageInfo<>(commissionRatio);
		return pageInfo;
	}
	
	/**
	 * 分佣/邀请比例详情
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public CommissionRatio getById(Long id) {
		CommissionRatio commissionRatio=siteDao.getById(id);
		return commissionRatio;
	}
	
	/**
	 * 修改级别分佣/邀请比例
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void update(CommissionRatio commissionRatio) {
		Integer update=siteDao.updateCommissionRatio(commissionRatio);
		if (update == Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.UPDATE_COMMISSION_RATIO_ERROR);
		}
	}

}
