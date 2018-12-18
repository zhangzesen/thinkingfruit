package com.thinkingFruit.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkingFruit.admin.entity.News;
import com.thinkingFruit.admin.mapper.NewsDao;
import com.thinkingFruit.admin.service.NewsService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.CodeMsg;

/**
 * @author wulei
 *
 * @date 2018年11月21日
 *
 * @package com.thinkingFruit.admin.service
 *
 * @description 新闻发布
 */
@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	NewsDao newsDao;

	@Override
	public Pagination<News> paginationNews(Pagination<News> pagination, Map<String, String> queryMap) {
		// TODO Auto-generated method stub
		Integer page = null;
		Integer limit = null;
		if (queryMap == null || (page = Integer.valueOf(queryMap.get("page"))) == null
				|| (limit = Integer.valueOf(queryMap.get("limit"))) == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		pagination.setPageNum(page);
		pagination.setPageSize(limit);

		Integer totalItemsCount = newsDao.getCountByQuery(queryMap);
		List<News> secondCategoryItems = newsDao.paginationNews(queryMap, pagination);
		pagination.setItems(secondCategoryItems);
		pagination.setTotalItemsCount(totalItemsCount);
		return pagination;
	}

	// 删除新闻
	@Override
	public void deleteNews(Long id) {
		newsDao.deleteNews(id);
	}

	// 添加新闻
	@Override
	public void addNews(News news) {
		newsDao.addNews(news);
	}

	// 查询新闻
	@Override
	public News findNewsById(Long id) {
		return newsDao.findNewsById(id);
	}

	// 修改新闻
	@Override
	public void editNews(News news) {
		newsDao.editNews(news);
	}

	@Override
	public void editAbout(News news) {
		newsDao.editAbout(news);
	}

}
