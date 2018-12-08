package com.thinkingFruit.admin.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.thinkingFruit.admin.entity.Commision;
import com.ysdevelop.common.page.Pagination;

public interface CommisionDao {

	//查询所对应的记录总数
	Integer getCountByQuery(@Param("queryMap") Map<String, String> queryMap);

	//查询所对应的佣金记录
	List<Commision> paginationCommision(@Param("queryMap") Map<String, String> queryMap,@Param("pagination") Pagination<Commision> pagination);

	//根据id查询佣金信息
	Commision findCommisionById(@Param("id") Long id);

	//添加总的佣金
	void addTotalCommision(@Param("commision") Commision commision);

	//添加个人佣金
	void addPersonCommision(@Param("commisions") List<Commision> personCommisions);

	//查询所对应的个人记录总数
	Integer getCountByQueryPerson(@Param("queryMap") Map<String, String> queryMap);

	//查询所对应的个人佣金记录
	List<Commision> paginationCommisionPerson(@Param("queryMap") Map<String, String> queryMap,@Param("pagination") Pagination<Commision> pagination);

	//通过订单号来查询该笔订单佣金受益人群信息
	List<Commision> findMemberCommisionByOrderNo(@Param("orderNo") String orderNo);

	Integer addCommision(Commision commision);

}
