package com.thinkingFruit.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.thinkingFruit.admin.entity.Member;
import com.thinkingFruit.admin.entity.MemberBalance;


/**
 * @author	zhangzesen
 *
 * @package	com.thinkingFruit.admin.controller
 *
 * @date	2018年11月30日
 *
 * @description	代理
 * 
 */
public interface MemberDao {


	/**
	 * 查询所有代理
	 * @param queryMap
	 * @return 代理集合
	 */
	List<Member> paginationMember(@Param(value="queryMap")Map<String, String> queryMap);

	/**
	 * 查询代理信息
	 * @param id 代理id
	 * @return 代理
	 */
	Member memberById(@Param(value="id")Long id);

    /**
     * 修改代理信息
     * @param member 代理
     * @return
     */
	Integer updataById(Member member);

	/**
	 * 删除代理
	 * @param id 代理id
	 * @return
	 */
	Integer deleteById(@Param(value="id")Long id);

	/**
	 * 提现修改代理余额
	 * @param memberBalance 代理余额
	 * @return
	 */
	Integer putForward(@Param(value="memberBalance") MemberBalance memberBalance);
	
	/**
	 * 获取所有待审核的代理列表
	 * @param queryMap
	 * @return 待审核的代理集合
	 */
	List<Member> paginationExamine(@Param(value="queryMap")Map<String, String> queryMap);
	
	/**
	 * 修改待审核的代理通过
	 * @param orderMemberId 待审核的代理id
	 * @return
	 */
	Integer examineUpdate(@Param(value="id")Long orderMemberId);
}
