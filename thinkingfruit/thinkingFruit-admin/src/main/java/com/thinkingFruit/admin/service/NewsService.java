package com.thinkingFruit.admin.service;

import java.util.Map;

import com.thinkingFruit.admin.entity.News;
import com.ysdevelop.common.page.Pagination;

public interface NewsService {
	/**
	 * @author wulei
	 *
	 * @date 2018年11月21日
	 *
	 * @package com.thinkingFruit.admin.service
	 *
	 * @description 新闻发布
	 */

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
	//根据id修改关于我们
	void editAbout(News news);
    //添加关于我们
	void addAbout(News news);
	//搜索关于我们
	News findAbout();

}
