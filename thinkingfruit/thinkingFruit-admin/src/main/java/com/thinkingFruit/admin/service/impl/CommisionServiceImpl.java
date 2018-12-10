package com.thinkingFruit.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thinkingFruit.admin.entity.Commision;
import com.thinkingFruit.admin.mapper.CommisionDao;
import com.thinkingFruit.admin.service.CommisionService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.CodeMsg;

@Service
public class CommisionServiceImpl implements CommisionService {
	/**
	 * @author wulei
	 *
	 * @date 2018年11月21日
	 *
	 * @package com.thinkingFruit.admin.service
	 *
	 * @description 佣金列表
	 */
	@Autowired
	CommisionDao commisionDao;
	/**
	 * 获取所有佣金
	 */
	@Override
	public PageInfo<Commision> paginationCommision(Map<String, String> queryMap) {
		String pageSize = queryMap.get("limit");
		String pageNum = queryMap.get("page");
		if (pageSize == null || pageNum == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		
		Integer integerPageSize = Integer.parseInt(pageSize);
		Integer integerPageNum = Integer.parseInt(pageNum);
		PageHelper.startPage(integerPageNum, integerPageSize, Boolean.TRUE);
		List<Commision> paginationCommision = commisionDao.paginationCommision(queryMap);
		PageInfo<Commision> pageInfo = new PageInfo<>(paginationCommision);
		return pageInfo;
	}
	// 通过id查询
	@Override
	public Commision findCommisionById(Long id) {
		Commision commision =commisionDao.findCommisionById(id);
		Long inviterId =commision.getInviterId();
		Long inviterUpperId=commision.getInviterUpperId();
		String inviterName=commisionDao.findInviterName(inviterId);
		String inviterUpperName=commisionDao.findInviterUpperName(inviterUpperId);
		commision.setInviterName(inviterName);
		commision.setInviterUpperName(inviterUpperName);
		return commision;
	}

	// 佣金总和
	@Override
	public void addTotalCommision(Commision commision) {
		commisionDao.addTotalCommision(commision);
	}

	// 个人佣金
	@Override
	public void addPersonCommision(List<Commision> personCommisions) {
		commisionDao.addPersonCommision(personCommisions);
	}
    //个人佣金列表
	@Override
	public PageInfo<Commision> personCommision(Map<String, String> queryMap) {
		String pageSize = queryMap.get("limit");
		String pageNum = queryMap.get("page");
		if (pageSize == null || pageNum == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		
		Integer integerPageSize = Integer.parseInt(pageSize);
		Integer integerPageNum = Integer.parseInt(pageNum);
		PageHelper.startPage(integerPageNum, integerPageSize, Boolean.TRUE);
		List<Commision> paginationCommision = commisionDao.personCommision(queryMap);
		
		PageInfo<Commision> pageInfo = new PageInfo<>(paginationCommision);
		return pageInfo;
	}


	@Override
	public List<Commision> findMemberCommisionByOrderNo(String orderNo) {
		return commisionDao.findMemberCommisionByOrderNo(orderNo);
	}

}
