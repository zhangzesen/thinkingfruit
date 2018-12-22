package com.thinkingFruit.admin.mapper;

import java.util.List;

import com.thinkingFruit.admin.entity.PanelStatistics;


/**
 * @author zhangzesen
 *
 * @date 2018年12月22日
 *
 * @package com.thinkingFruit.admin.mapper
 *
 * @description 首页统计
 */
public interface PanelStatisticsDao {
	
	/**
	 * 将数据插入统计表
	 */
	void addStatistics();
	
	/**
	 * 查询折线图
	 * @return 统计表所有数据
	 */
	List<PanelStatistics> findStatisticsAll();
	
	/**
	 * 查找总统计
	 * @return 总统计数据
	 */
	PanelStatistics findStatisticsTotal();
	
	/**
	 * 日统计
	 * @return 
	 */
	PanelStatistics dayStatistics();
	
	/**
	 * 月统计
	 * @return
	 */
	PanelStatistics monthStatistics();
	
	/**
	 * 根据省份查询订单数
	 * @param province 省
	 * @return 订单数
	 */
	Long getOrderTotalByProvince(String province);
	
	/**
	 * 获取代理总数
	 * @return 代理总数
	 */
	Long getAgent();
			
}
