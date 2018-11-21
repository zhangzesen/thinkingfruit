package com.thinkingFruit.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.thinkingFruit.admin.entity.Commision;
import com.ysdevelop.common.page.Pagination;

public interface CommisionRankingDao {

	Integer getCountByQuery(@Param("queryMap") Map<String, String> queryMap);

	List<Commision> pagination(@Param("queryMap") Map<String, String> queryMap,@Param("pagination") Pagination<Commision> pagination);

}
