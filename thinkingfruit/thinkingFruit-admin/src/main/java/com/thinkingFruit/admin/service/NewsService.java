package com.thinkingFruit.admin.service;

import java.util.Map;

import com.thinkingFruit.admin.entity.News;
import com.ysdevelop.common.page.Pagination;

public interface NewsService {

	//查询与遍历新闻
	Pagination<News> paginationNews(Pagination<News> pagination, Map<String, String> queryMap);

	//删除新闻
	void deleteNews(Long id);

	//添加新闻
	void addNews(News news);

	//根据新闻id查询id
	News findNewsById(Long id);

	//根据id修改新闻信息
	void editNews(News news);

}
