package com.thinkingFruit.admin.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
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
public interface MemberService {

	/**
	 * 查询所有的代理
	 * @param queryMap
	 * @return 代理集合
	 */
	PageInfo<Member> paginationMember(Map<String, String> queryMap);

	/**
	   * 查询级别名称
	 * @param id 代理id
	 * @return
	 */
	Member memberById(Long id);

    /**
               * 根据代理修改信息
     * @param member 代理
     */
	void updateById(Member member);
    /**
               * 删除代理
     * @param id 代理id
     */
	void deleteById(Long id);

	/**
	 * 提取现金时对余额进行更新(减)
	 * @param memberBalance
	 */
	void putForward(MemberBalance memberBalance);
	
	/**
	 * 获取所有注册待审核代理
	 * @param queryMap
	 * @return 待审核代理分页
	 */
	PageInfo<Member> paginationExamine(Map<String, String> queryMap);
	/**
	 * 获取所有升级待审核代理
	 * @param queryMap
	 * @return 待审核代理分页
	 */
	PageInfo<Member> upPaginationUpExamine(Map<String, String> queryMap);

	/**
	 * 取消代理注册
	 * @param id 代理id
	 */
	void cancellation(Long id);

	/**
	 * 取消代理升级
	 * @param id 代理id
	 */
	void cancelUpgrade(Long id);
}
