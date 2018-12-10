package com.thinkingFruit.admin.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.thinkingFruit.admin.entity.Commision;
import com.ysdevelop.common.page.Pagination;

public interface CommisionService {
	/**
	 * @author wulei
	 *
	 * @date 2018年11月21日
	 *
	 * @package com.thinkingFruit.admin.service
	 *
	 * @description 佣金列表
	 */
	//遍历与查询佣金信息
   PageInfo<Commision> paginationCommision(Map<String, String> queryMap);

	//根据id查询佣金信息
	Commision findCommisionById(Long id);

	//添加总佣金
	void addTotalCommision(Commision commision);

	//添加个人佣金
	void addPersonCommision(List<Commision> personCommisions);
    //查询个人佣金
	PageInfo<Commision> personCommision(Map<String, String> queryMap);
	//通过订单号来查询该笔订单佣金受益人群信息
	List<Commision> findMemberCommisionByOrderNo(String orderNo);

}
