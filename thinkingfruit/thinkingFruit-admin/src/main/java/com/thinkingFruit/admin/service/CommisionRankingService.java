package com.thinkingFruit.admin.service;

import java.util.Map;

import com.thinkingFruit.admin.entity.Commision;
import com.ysdevelop.common.page.Pagination;

public interface CommisionRankingService {
	/**
	 * @author wulei
	 *
	 * @date 2018年11月21日
	 *
	 * @package com.thinkingFruit.admin.service
	 *
	 * @description 佣金排名
	 */
	//查询与遍历
	Pagination<Commision> pagination(Pagination<Commision> pagination, Map<String, String> queryMap);

}
