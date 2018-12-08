package com.thinkingFruit.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	// 佣金列表
	@Override
	public Pagination<Commision> paginationCommision(Pagination<Commision> pagination, Map<String, String> queryMap) {

		Integer page = null;
		Integer limit = null;
		if (queryMap == null || (page = Integer.valueOf(queryMap.get("page"))) == null
				|| (limit = Integer.valueOf(queryMap.get("limit"))) == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		pagination.setPageNum(page);
		pagination.setPageSize(limit);

		Integer totalItemsCount = commisionDao.getCountByQuery(queryMap);
		List<Commision> commisionItems = commisionDao.paginationCommision(queryMap, pagination);
		pagination.setItems(commisionItems);
		pagination.setTotalItemsCount(totalItemsCount);

		return pagination;
	}

	// 通过id查询
	@Override
	public Commision findCommisionById(Long id) {
		return commisionDao.findCommisionById(id);
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

	@Override
	public Pagination<Commision> paginationCommisionPerson(Pagination<Commision> pagination,
			Map<String, String> queryMap) {

		Integer page = null;
		Integer limit = null;
		if (queryMap == null || (page = Integer.valueOf(queryMap.get("page"))) == null
				|| (limit = Integer.valueOf(queryMap.get("limit"))) == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		pagination.setPageNum(page);
		pagination.setPageSize(limit);

		Integer totalItemsCount = commisionDao.getCountByQueryPerson(queryMap);
		List<Commision> commisionItems = commisionDao.paginationCommisionPerson(queryMap, pagination);
		pagination.setItems(commisionItems);
		pagination.setTotalItemsCount(totalItemsCount);

		return pagination;
	}

	@Override
	public List<Commision> findMemberCommisionByOrderNo(String orderNo) {
		return commisionDao.findMemberCommisionByOrderNo(orderNo);
	}

}
