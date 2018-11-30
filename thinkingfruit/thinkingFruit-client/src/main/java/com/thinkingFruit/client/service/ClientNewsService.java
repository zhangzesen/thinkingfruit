package com.thinkingFruit.client.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.thinkingFruit.client.entity.ClientNews;




/**
 * @author wulei
 *
 * @date 2018年11月17日
 *
 * @package com.thinkingFruit.client.service
 *
 * @description 文章
 */
public interface ClientNewsService {
	

	List<ClientNews> ClientNewsList();
	
	
	ClientNews findNewsById(HttpServletRequest request, Long id);
	
}
