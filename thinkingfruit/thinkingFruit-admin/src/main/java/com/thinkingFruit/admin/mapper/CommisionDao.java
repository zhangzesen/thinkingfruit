package com.thinkingFruit.admin.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.thinkingFruit.admin.entity.Commision;
import com.ysdevelop.common.page.Pagination;

public interface CommisionDao {

	//全部订单佣金
	List<Commision> paginationCommision(@Param(value="queryMap")Map<String, String> queryMap);
	//根据id查询佣金信息
	Commision findCommisionById(@Param("id") Long id);
	 //查找上级姓名
    String findInviterName(Long inviteId);
    //查找上上级姓名
	String findInviterUpperName(Long inviterUpperId);

	//添加总的佣金
	void addTotalCommision(@Param("commision") Commision commision);

	//添加个人佣金
	void addPersonCommision(@Param("commisions") List<Commision> personCommisions);

	//查找个人佣金列表
		List<Commision> personCommision(@Param(value="queryMap")Map<String, String> queryMap);

	//通过订单号来查询该笔订单佣金受益人群信息
	List<Commision> findMemberCommisionByOrderNo(@Param("orderNo") String orderNo);

	Integer addCommision(Commision commision);

}
