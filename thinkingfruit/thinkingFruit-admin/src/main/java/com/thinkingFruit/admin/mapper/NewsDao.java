package com.thinkingFruit.admin.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.thinkingFruit.admin.entity.News;
import com.ysdevelop.common.page.Pagination;

public interface NewsDao {
	/**
	 * @author wulei
	 *
	 * @date 2018年11月21日
	 *
	 * @package com.thinkingFruit.admin.mapper
	 *
	 * @description 新闻
	 */

	//查询与遍历新闻
	List<News> paginationNews(@Param("queryMap") Map<String, String> queryMap,@Param("pagination") Pagination<News> pagination);

	//统计出符合条件的数量
	Integer getCountByQuery(@Param("queryMap") Map<String, String> queryMap);

	//删除新闻
	void deleteNews(@Param("id") Long id);

	//添加新闻
	void addNews(@Param("news") News news);

	//根据新闻id查询新闻
	News findNewsById(@Param("id")Long id);

	//修改新闻信息
	void editNews(@Param("news")News news);

}
