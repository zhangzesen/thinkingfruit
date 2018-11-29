package com.thinkingFruit.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkingFruit.client.entity.ClientCommodity;
import com.thinkingFruit.client.mapper.ClientCommodityDao;
import com.thinkingFruit.client.service.ClientCommodityService;
@Service
public class ClientCommodityImpl implements ClientCommodityService {
	
	@Autowired
	ClientCommodityDao clientCommodityDao;
	
	@Override
	public List<ClientCommodity> ClientCommodityList() {
		List<ClientCommodity> clientCommodityList = clientCommodityDao.ClientCommodityList();
		return clientCommodityList;
	}

	@Override
	public ClientCommodity findCommodityById(Long id) {
		ClientCommodity findCommodityById = clientCommodityDao.findCommodityById(id);
		List<String> findCommodityImagesById = clientCommodityDao.findCommodityImagesById(id);
		for (String string : findCommodityImagesById) {
			System.out.println("========="+string);
		}
		findCommodityById.setDetailsImagePaths(findCommodityImagesById);
		return findCommodityById;
	}

	

}
