package com.thinkingFruit.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkingFruit.admin.entity.Cash;
import com.thinkingFruit.admin.entity.MemberBalance;
import com.thinkingFruit.admin.mapper.CashDao;
import com.thinkingFruit.admin.service.CashService;
import com.thinkingFruit.admin.service.MemberService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.utils.Constant;


@Service
public class CashServiceImpl implements CashService {

	@Autowired
	CashDao cashDao;
	
	@Autowired
	MemberService memberService;
	
	@Override
	public Pagination<Cash> paginationCash(Pagination<Cash> pagination, Map<String, String> queryMap) {
		Integer page = null;
		Integer limit = null;
		if (queryMap == null || (page = Integer.valueOf(queryMap.get("page"))) == null || (limit = Integer.valueOf(queryMap.get("limit"))) == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		pagination.setPageNum(page);
		pagination.setPageSize(limit);
		
		
		Integer totalItemsCount = cashDao.getCountByQuery(queryMap);
		List<Cash> cashItems = cashDao.paginationCash(queryMap, pagination);
		
		pagination.setItems(cashItems);
		pagination.setTotalItemsCount(totalItemsCount);
		return pagination;
	}

	@Override
	public void editCash(Long id) {
		//根据id查询cash信息
		Cash cashReplace = cashDao.findCashById(id);
		
		if(cashReplace.getStatus() == Constant.DEFALULT_ZERO){
			MemberBalance memberBalance = new MemberBalance();
			memberBalance.setMemberId(cashReplace.getMemberId());
			memberBalance.setBalance((double)cashReplace.getCash());
			memberService.putForward(memberBalance);
		}
		cashDao.editCash(id);
	}

}
