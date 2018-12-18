package com.thinkingFruit.client.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkingFruit.client.entity.ClientNews;
import com.thinkingFruit.client.mapper.ClientNewsDao;
import com.thinkingFruit.client.service.ClientNewsService;
@Service
public class ClientNewsServiceImpl implements ClientNewsService {
	
	@Autowired
	ClientNewsDao clientNewsDao;
	
	
	//列表
	@Override
	public List<ClientNews> ClientNewsList() {
		List<ClientNews> clientNewsList = clientNewsDao.ClientNewsList();
		return clientNewsList;
	}
   //根据id查询新闻信息
	@Override
	public ClientNews findNewsById(HttpServletRequest request,Long id) {
		ClientNews findNewsById = clientNewsDao.findNewsById(id);
		return findNewsById;
	}
	@Override
	public ClientNews about() {
		ClientNews ClientNews=clientNewsDao.findAbout();
		return ClientNews;
	}

	


	

	

}
