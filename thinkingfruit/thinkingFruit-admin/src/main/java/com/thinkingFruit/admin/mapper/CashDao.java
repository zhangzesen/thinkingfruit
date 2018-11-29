package com.thinkingFruit.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.thinkingFruit.admin.entity.Cash;
import com.ysdevelop.common.page.Pagination;


public interface CashDao {

	//统计出所要遍历与查询的数量
	Integer getCountByQuery(@Param("queryMap") Map<String, String> queryMap,@Param("nicknameReplace") byte[] nicknameReplace);

	//遍历与查询出数据
	List<Cash> paginationCash(@Param("queryMap") Map<String, String> queryMap,@Param("pagination") Pagination<Cash> pagination,@Param("nicknameReplace") byte[] nicknameReplace);

	//修改提现状态
	void editCash(@Param("id")Long id);

	//根据id查询cash信息
	Cash findCashById(@Param("id")Long id);

}
