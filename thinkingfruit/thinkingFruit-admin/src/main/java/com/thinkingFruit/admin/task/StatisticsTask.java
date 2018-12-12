package com.thinkingFruit.admin.task;

public interface StatisticsTask {
	
	void addStatistics();
	
	//存入缓存
	void depositCache();

	//初始化
	void initialization();

}
