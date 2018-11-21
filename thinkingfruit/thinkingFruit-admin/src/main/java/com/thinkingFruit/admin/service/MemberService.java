package com.thinkingFruit.admin.service;

import java.util.Map;

import com.thinkingFruit.admin.entity.Member;
import com.ysdevelop.common.page.Pagination;


public interface MemberService {
	/**
	 * @author wulei
	 *
	 * @date 2018年11月21日
	 *
	 * @package com.thinkingFruit.admin.service
	 *
	 * @description 代理列表
	 */

	//查询与遍历
	Pagination<Member> paginationCategory(Pagination<Member> pagination, Map<String, String> queryMap);

	//查询级别名称
	Member memberLevelId(Long id);

    //根据id修改信息
	void updateById(Member member);
   //删除代理
	void deleteById(Long id);



}
