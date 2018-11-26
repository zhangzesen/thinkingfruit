package com.thinkingFruit.admin.mapper;

import java.util.List;
import java.util.Map;

import com.thinkingFruit.admin.entity.CommissionRatio;

/**
 * @author zhangzesen
 *
 * @date 2018年11月26日
 *
 * @package com.thinkingFruit.admin.mapper
 *
 * @description 设置分佣/邀请比例
 */
public interface SiteDao {
	/**
	 * 获取所有级别的分佣/邀请比例集合
	 * @param queryMap
	 * @return 分佣/邀请比例集合
	 */
	List<CommissionRatio> list(Map<String, String> queryMap);
	
	/**
	 * 获取单个级别分佣/邀请比例
	 * @param id 级别id
	 * @return 单个级别分佣/邀请比例
	 */
	CommissionRatio getById(Long id);
	
	/**
	 * 修改SiteDao.java
	 * @param commissionRatio 级别
	 * @return
	 */
	Integer updateCommissionRatio(CommissionRatio commissionRatio);

}
