package com.thinkingFruit.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thinkingFruit.admin.entity.Commision;
import com.thinkingFruit.admin.mapper.CommisionRankingDao;
import com.thinkingFruit.admin.service.CommisionRankingService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.CodeMsg;


@Service(value="commisionRankingServiceImpl")
public class CommisionRankingServiceImpl implements CommisionRankingService{
	/**
	 * @author wulei
	 *
	 * @date 2018年11月21日
	 *
	 * @package com.thinkingFruit.admin.service
	 *
	 * @description 佣金排名
	 */
	@Autowired
	CommisionRankingDao commisionRankingDao;

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
		List<Commision> paginationCommision = commisionRankingDao.paginationCommision(queryMap);
		PageInfo<Commision> pageInfo = new PageInfo<>(paginationCommision);
		return pageInfo;
	}

}
