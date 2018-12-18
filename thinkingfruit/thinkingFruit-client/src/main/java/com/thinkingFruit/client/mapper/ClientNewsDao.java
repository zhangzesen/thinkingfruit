package com.thinkingFruit.client.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkingFruit.client.entity.ClientNews;



/**
 * @author wulei
 *
 * @date 2018年11月26日
 *
 * @package com.thinkingFruit.client.mapper
 *
 * @description 新闻
 */
public interface ClientNewsDao {
		
	//新闻列表
	List<ClientNews> ClientNewsList();
	
	//通过id查看新闻详情
	ClientNews findNewsById(@Param("id")Long id);
	//寻找关于我们详情
    ClientNews findAbout();
	
}
