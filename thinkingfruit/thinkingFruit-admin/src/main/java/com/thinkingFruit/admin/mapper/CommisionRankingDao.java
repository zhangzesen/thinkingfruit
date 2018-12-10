package com.thinkingFruit.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.thinkingFruit.admin.entity.Commision;

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
	List<Commision> paginationCommision(@Param(value="queryMap")Map<String, String> queryMap);

}
