package com.thinkingFruit.admin.task.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.thinkingFruit.admin.key.StatisticsKey;
import com.thinkingFruit.admin.service.PanelStatisticsService;
import com.thinkingFruit.admin.task.StatisticsTask;
import com.ysdevelop.common.redis.RedisService;
import com.ysdevelop.common.utils.Constant;

@Component
public class StatisticsTaskImpl implements StatisticsTask{
	
	@Autowired
	PanelStatisticsService panelStatisticsService;
	
	@Autowired
	RedisService redisService;
	
	@Scheduled(cron="0 0 2 * * ?")
	@Override
	public void addStatistics(){
		panelStatisticsService.addStatistics();
	}
	//存入缓存
	@Scheduled(cron="0 5 2 * * ?")
	@Override
	public void depositCache() {
		
		Map<String,Object> statistics = new HashMap<>();
		statistics.put("dayStatistics", panelStatisticsService.dayStatistics());//日统计查询
		statistics.put("monthStatistics", panelStatisticsService.monthStatistics());//月统计查询
		statistics.put("lineChart", panelStatisticsService.findStatisticsAll());//2个折线图
		statistics.put("allTotal", panelStatisticsService.findStatisticsTotal());//总订单量总交易金额总会员数
		statistics.put("map", panelStatisticsService.findOrderTotalByProvince(Constant.province));//地图
		statistics.put("agent", panelStatisticsService.getAgent());//代理
		redisService.set(StatisticsKey.statisticsKey, "statistics",statistics);
				
	}
	//初始化
	@Scheduled(cron="0 47 11 * * ?")
	@Override
	public void initialization() {

		Map<String,Object> statistics = new HashMap<>();
		statistics.put("dayStatistics", panelStatisticsService.dayStatistics());//日统计查询
		statistics.put("monthStatistics", panelStatisticsService.monthStatistics());//月统计查询
		statistics.put("lineChart", panelStatisticsService.findStatisticsAll());//2个折线图
		statistics.put("allTotal", panelStatisticsService.findStatisticsTotal());//总订单量总交易金额总会员数
		statistics.put("map", panelStatisticsService.findOrderTotalByProvince(Constant.province));//地图
		statistics.put("agent", panelStatisticsService.getAgent());//代理
		
		redisService.set(StatisticsKey.statisticsKey, "statistics",statistics);
		
	}
	

}
