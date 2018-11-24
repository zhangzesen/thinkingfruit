package com.thinkingFruit.admin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkingFruit.admin.entity.DataList;
import com.thinkingFruit.admin.entity.PanelStatistics;
import com.thinkingFruit.admin.mapper.PanelStatisticsDao;
import com.thinkingFruit.admin.service.PanelStatisticsService;

import net.sf.json.JSONArray;

@Service
public class PanelStatisticsServiceImpl implements PanelStatisticsService{

	@Autowired
	PanelStatisticsDao panelStatisticsDao;
	/**
	 * 添加统计数据
	 * */
	@Override
	public void addStatistics() {
		panelStatisticsDao.addStatistics();
	}
	/**
	 * 查询折线图
	 * */
	@Override
	public List<PanelStatistics> findStatisticsAll() {
		return panelStatisticsDao.findStatisticsAll();
	}  
	/**
	 * 查找总金额
	 * */
	@Override
	public PanelStatistics findStatisticsTotal() {
		return panelStatisticsDao.findStatisticsTotal();
	}
	/**
	 * 日统计
	 * */
	@Override
	public PanelStatistics dayStatistics() {		
		return panelStatisticsDao.dayStatistics();
	}
	/**
	 * 月统计
	 * */
	@Override
	public PanelStatistics monthStatistics() {
		return panelStatisticsDao.monthStatistics();
	}

	/**
	 * 根据省份查询订单
	 * */
	@Override
	public Map<String, Object> findOrderTotalByProvince(String province) {
		JSONArray array = JSONArray.fromObject(province);
		List<Object> list = new ArrayList<>();
		for (Object object : array) {
			Long count = panelStatisticsDao.getOrderTotalByProvince(object.toString());
			DataList dataList = new DataList();
			dataList.setName(object.toString());
			dataList.setValue(count);
			list.add(dataList);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		return map;
	}
/**
 * 获取代理总数
 * */
	@Override
	public Long getAgent() {
		return panelStatisticsDao.getAgent();
	}
	
}
