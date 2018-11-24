package com.thinkingFruit.admin.key;

import com.ysdevelop.common.redis.BasePrefix;

public class StatisticsKey extends BasePrefix{

	public StatisticsKey(int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
	}

	public static StatisticsKey statisticsKey = new StatisticsKey(0, "statistics");
	
}
