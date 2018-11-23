package com.thinkingFruit.admin.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.thinkingFruit.admin.entity.CommissionRatio;

/**
 * @author zhangzesen
 *
 * @date 2018年11月23日
 *
 * @package com.thinkingFruit.admin.service
 *
 * @description 设置：分佣/邀请比例设置
 */
public interface SiteService {
	
	/**
	 * 分佣/邀请比例分页
	 * @param queryMap
	 * @return 所有级别分佣/邀请比例
	 */
	PageInfo<CommissionRatio> paginationOrder(Map<String, String> queryMap);
	
	/**
	 * 分佣/邀请比例详情
	 * @param id 级别id
	 * @return 分佣/邀请比例详情
	 */
	CommissionRatio getById(Long id);
	
	/**
	 * 修改级别分佣/邀请比例
	 * @param commissionRatio 级别
	 */
	void update(CommissionRatio commissionRatio);
	
}
