package com.thinkingFruit.client.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkingFruit.client.entity.Agent;
import com.thinkingFruit.client.helper.PasswordAgentHelper;
import com.thinkingFruit.client.mapper.AgentDao;
import com.thinkingFruit.client.service.AgentService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;

@Service
public class AgentServiceImpl implements AgentService {

	@Autowired
	private AgentDao agentDao;
	
	@Autowired
	private PasswordAgentHelper passwordAgentHelper;
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void addAgent(Agent agent) {
		// 密码加密处理
		passwordAgentHelper.encryptPassword(agent);	
		System.out.println("agent.getLoginName()"+agent.getLoginName());
		agentDao.addAgent(agent);
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Agent getAgentByName(String loginName) {
		if (loginName == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		return agentDao.getAgentByName(loginName);
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Agent getAgentById(Long id) {
		if (id == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		return agentDao.getAgentById(id);
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void checkName(Map<String, String> queryMap) {
		String id = queryMap.get("id");
		String loginName = queryMap.get("loginName");
		Agent agentByName = agentDao.getAgentByName(loginName);
		if(id != null){
			Agent agentById = agentDao.getAgentById(Long.valueOf(id));
			if(agentByName != null && agentByName.getId() != agentById.getId()){
				throw new WebServiceException(CodeMsg.USERNAME_EXIST);
			}
		}else{
			if(agentByName != null){
				throw new WebServiceException(CodeMsg.USERNAME_EXIST);
			}
		}
		
	}


}
