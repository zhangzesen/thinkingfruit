package com.thinkingFruit.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkingFruit.admin.entity.Member;
import com.thinkingFruit.admin.entity.MemberBalance;
import com.thinkingFruit.admin.mapper.MemberDao;
import com.thinkingFruit.admin.service.MemberService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.CodeMsg;



@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;
	
	@Override
	public Pagination<Member> paginationCategory(Pagination<Member> pagination, Map<String, String> queryMap) {
		Integer page = null;
		Integer limit = null;
		if (queryMap == null || (page = Integer.valueOf(queryMap.get("page"))) == null || (limit = Integer.valueOf(queryMap.get("limit"))) == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		pagination.setPageNum(page);
		pagination.setPageSize(limit);
		
		byte[] nicknameReplace = null;
		
		//当查询昵称的时候，将昵称转换为二进制
		if(queryMap.get("nicknameStr") != null){
			nicknameReplace = queryMap.get("nicknameStr").getBytes();
		}
		
		Integer totalItemsCount = memberDao.getCountByQuery(queryMap,nicknameReplace);
		List<Member> memberItems = memberDao.paginationSecondCategory(queryMap, pagination,nicknameReplace);		
		pagination.setItems(memberItems);
		pagination.setTotalItemsCount(totalItemsCount);
		
		return pagination;
	}
//查询代理信息
	@Override
	public Member memberLevelId(Long id) {
		Member member=memberDao.memberLevelIdById(id);
		return member;
	}
//修改代理父id和级别
	@Override
	public void updateById(Member member) {
		memberDao.updataById(member);
		memberDao.updataById1(member);
		
}
//删除代理。status变为3(不显示)
	@Override
	public void deleteById(Long id) {
		Integer changeCount =memberDao.deleteById(id);
	}
	//减少余额
	@Override
	public void putForward(MemberBalance memberBalance) {
		int result = memberDao.putForward(memberBalance);
		if(result<=0){
			throw new WebServiceException(CodeMsg.CASH_NOT_ENOUGH);
		}
	}
}