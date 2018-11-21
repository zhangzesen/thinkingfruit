package com.thinkingFruit.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.thinkingFruit.admin.entity.Commision;
import com.ysdevelop.common.page.Pagination;

public interface CommisionRankingDao {
	/**
	 * @author wulei
	 *
	 * @date 2018年11月21日
	 *
	 * @package com.thinkingFruit.admin.mapper
	 *
	 * @description 个人佣金排名
	 */
	Integer getCountByQuery(@Param("queryMap") Map<String, String> queryMap);

	List<Commision> pagination(@Param("queryMap") Map<String, String> queryMap,@Param("pagination") Pagination<Commision> pagination);

}
