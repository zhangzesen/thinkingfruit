package com.thinkingFruit.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thinkingFruit.admin.entity.Member;
import com.thinkingFruit.admin.entity.MemberBalance;
import com.thinkingFruit.admin.helper.PasswordHelper;
import com.thinkingFruit.admin.mapper.MemberDao;
import com.thinkingFruit.admin.service.MemberService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.utils.Constant;


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
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;
//	@Autowired
//	PasswordHelper passwordHelper;
	/**
	 * 获取所有代理
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public PageInfo<Member> paginationMember(Map<String, String> queryMap) {
		String pageSize = queryMap.get("limit");
		String pageNum = queryMap.get("page");
		if (pageSize == null || pageNum == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		Integer integerPageSize = Integer.parseInt(pageSize);
		Integer integerPageNum = Integer.parseInt(pageNum);
		PageHelper.startPage(integerPageNum, integerPageSize, Boolean.TRUE);
		List<Member> paginationMember = memberDao.paginationMember(queryMap);
		PageInfo<Member> pageInfo = new PageInfo<>(paginationMember);
		return pageInfo;
	}
	
    /**
     * 查询代理信息
     */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Member memberById(Long id) {
		Member member=memberDao.memberById(id);
		return member;
	}
	
	/**
	 * 修改代理邀请者id，和邀请者上级id及代理级别
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void updateById(Member member) {
		System.out.println("member.getInviterId()"+member.getInviterId());
		//将查出来的邀请者idset进代理实体类
		if(member.getInviterId()==Constant.DEFALULT_ZERO_INT) {
			member.setInviterUpperId(0L);
		}else {
			Member memberLevelIdById = memberDao.memberById(member.getInviterId());
			member.setInviterUpperId(memberLevelIdById.getInviterId());
		}
		System.out.println(member.getInviterUpperId());
		memberDao.updataById(member);
		
	}
	
	/**
	 * 删除代理
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void deleteById(Long id) {
		Integer changeCount =memberDao.deleteById(id);
		if(changeCount==Constant.DEFALULT_ZERO_INT){
			throw new WebServiceException(CodeMsg.AGENT_CANCEL_ERROR);
		}
	}
	
	/**
	 * 减少余额
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void putForward(MemberBalance memberBalance) {
		int result = memberDao.putForward(memberBalance);
		if(result<=Constant.DEFALULT_ZERO_INT){
			throw new WebServiceException(CodeMsg.CASH_NOT_ENOUGH);
		}
	}
	
	/**
	 * 获取所有注册待审核代理
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public PageInfo<Member> paginationExamine(Map<String, String> queryMap) {
		String pageSize = queryMap.get("limit");
		String pageNum = queryMap.get("page");
		if (pageSize == null || pageNum == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		
		Integer integerPageSize = Integer.parseInt(pageSize);
		Integer integerPageNum = Integer.parseInt(pageNum);
		PageHelper.startPage(integerPageNum, integerPageSize, Boolean.TRUE);
		List<Member> paginationMember = memberDao.paginationExamine(queryMap);
		PageInfo<Member> pageInfo = new PageInfo<>(paginationMember);
		return pageInfo;
	}
    
	/**
	 * 获取所有升级待审核代理
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public PageInfo<Member> upPaginationUpExamine(Map<String, String> queryMap) {
		String pageSize = queryMap.get("limit");
		String pageNum = queryMap.get("page");
		if (pageSize == null || pageNum == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		
		Integer integerPageSize = Integer.parseInt(pageSize);
		Integer integerPageNum = Integer.parseInt(pageNum);
		PageHelper.startPage(integerPageNum, integerPageSize, Boolean.TRUE);
		List<Member> paginationMember = memberDao.PaginationUpExamine(queryMap);
		PageInfo<Member> pageInfo = new PageInfo<>(paginationMember);
		return pageInfo;
	}

	/**
	 *  取消代理注册
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void cancellation(Long id) {
		Integer cancellation = memberDao.cancellation(id);
		if(cancellation==Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.CANCEL_REGISTERED_FAIL);
		}
	}

	/**
	 * 取消代理升级
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void cancelUpgrade(Long id) {
		Integer cancelUpgrade = memberDao.cancelUpgrade(id);
		if(cancelUpgrade==Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.CANCEL_UPGRADE_FAIL);
		}
	}
	/**
	 * 修改密码
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void updatePswd(Member member) {
		PasswordHelper.encryptPassword(member);
		System.out.println("pswd"+member.getPswd());
		System.out.println("pswd"+member.getId());
		memberDao.updatePswd(member);
	}
	
}