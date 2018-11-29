package com.thinkingFruit.admin.service;

import java.util.Map;

import com.thinkingFruit.admin.entity.Cash;
import com.ysdevelop.common.page.Pagination;


public interface CashService {

	//遍历与查询
	Pagination<Cash> paginationCash(Pagination<Cash> pagination, Map<String, String> queryMap);

	//修改提现状态
	void editCash(Long id);


}
