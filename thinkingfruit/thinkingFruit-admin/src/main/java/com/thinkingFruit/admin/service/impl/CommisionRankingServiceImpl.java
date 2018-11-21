package com.thinkingFruit.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkingFruit.admin.entity.Commision;
import com.thinkingFruit.admin.mapper.CommisionRankingDao;
import com.thinkingFruit.admin.service.CommisionRankingService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.CodeMsg;


@Service(value="commisionRankingServiceImpl")
public class CommisionRankingServiceImpl implements CommisionRankingService{
	
	@Autowired
	CommisionRankingDao commisionRankingDao;

	@Override
	public Pagination<Commision> pagination(Pagination<Commision> pagination, Map<String, String> queryMap) {
		Integer page = null;
		Integer limit = null;
		if (queryMap == null || (page = Integer.valueOf(queryMap.get("page"))) == null || (limit = Integer.valueOf(queryMap.get("limit"))) == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		pagination.setPageNum(page);
		pagination.setPageSize(limit);
		
		//当查询昵称的时候，将昵称转换为二进制
//		if(queryMap.get("nicknameStr") != null){
//			queryMap.put("nickname", queryMap.get("nickname").getBytes().toString());
//		}
		
		Integer totalItemsCount = commisionRankingDao.getCountByQuery(queryMap);
		List<Commision> items = commisionRankingDao.pagination(queryMap, pagination);
		
		//将二进制昵称转化为String类型
		for (int i = 0; i < items.size(); i++) {
			items.get(i).setNicknameStr();
		}
		
		pagination.setItems(items);
		pagination.setTotalItemsCount(totalItemsCount);
		return pagination;
	}

}
