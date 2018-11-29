package com.thinkingFruit.client.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkingFruit.client.entity.Agent;
import com.thinkingFruit.client.entity.ClientCommodity;
import com.thinkingFruit.client.mapper.AgentDao;
import com.thinkingFruit.client.mapper.ClientCommodityDao;
import com.thinkingFruit.client.service.ClientCommodityService;
@Service
public class ClientCommodityServiceImpl implements ClientCommodityService {
	
	@Autowired
	ClientCommodityDao clientCommodityDao;
	
	@Autowired
	private AgentDao agentDao;
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public List<ClientCommodity> ClientCommodityList() {
		List<ClientCommodity> clientCommodityList = clientCommodityDao.ClientCommodityList();
		return clientCommodityList;
	}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public ClientCommodity findCommodityById(HttpServletRequest request,Long id) {
		ClientCommodity findCommodityById = clientCommodityDao.findCommodityById(id);
		List<String> findCommodityImagesById = clientCommodityDao.findCommodityImagesById(id);
		findCommodityById.setDetailsImagePaths(findCommodityImagesById);
		HttpSession session = request.getSession();
		System.out.println("agentId"+session.getAttribute("agentId"));
		
		Agent agentById = agentDao.getAgentById((Long) session.getAttribute("agentId"));
		switch (agentById.getMemberLevelId().toString()) {
        case "1":
        	findCommodityById.setPrice(findCommodityById.getFirstPrice());
			break;
        case "2":
        	findCommodityById.setPrice(findCommodityById.getSecondPrice());
			break;
        case "3":
        	findCommodityById.setPrice(findCommodityById.getThirdPrice());
			break;
        case "4":
        	findCommodityById.setPrice(findCommodityById.getFourthPrice());
			break;
        case "5":
        	findCommodityById.setPrice(findCommodityById.getFifthPrice());
			break;
        default:
			break;
		}
		System.out.println("price"+findCommodityById.getPrice());
		return findCommodityById;
	}

	

}
