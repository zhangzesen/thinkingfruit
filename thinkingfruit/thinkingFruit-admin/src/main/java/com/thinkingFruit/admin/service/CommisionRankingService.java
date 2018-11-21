package com.thinkingFruit.admin.service;

import java.util.Map;

import com.thinkingFruit.admin.entity.Commision;
import com.ysdevelop.common.page.Pagination;

public interface CommisionRankingService {

	//查询与遍历
	Pagination<Commision> pagination(Pagination<Commision> pagination, Map<String, String> queryMap);

}
