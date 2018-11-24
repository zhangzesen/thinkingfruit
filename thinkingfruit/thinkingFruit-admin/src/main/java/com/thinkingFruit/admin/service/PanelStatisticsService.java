package com.thinkingFruit.admin.service;

import java.util.List;
import java.util.Map;

import com.thinkingFruit.admin.entity.PanelStatistics;


public interface PanelStatisticsService {

	//添加
	void addStatistics();

	//查询折线图
	List<PanelStatistics> findStatisticsAll();
	
	//查找总金额
	PanelStatistics findStatisticsTotal();
	
	//日统计
	PanelStatistics dayStatistics();
	
	//月统计
	PanelStatistics monthStatistics();
	
	//根据省份查询订单数
	Map<String, Object> findOrderTotalByProvince(String province);
	
	//获取代理总数
	Long getAgent();
	
}
