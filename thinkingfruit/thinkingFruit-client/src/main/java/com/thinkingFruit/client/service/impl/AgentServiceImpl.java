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

/**
 * @author zhangzesen
 *
 * @date 2018年11月30日
 *
 * @package com.thinkingFruit.client.service.impl
 *
 * @description 代理
 */
@Service
public class AgentServiceImpl implements AgentService {

	@Autowired
	private AgentDao agentDao;
	
	@Autowired
	private PasswordAgentHelper passwordAgentHelper;
	
	/**
	 * 	向数据库中添加一条代理数据
	 * @param agent 代理
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void addAgent(Agent agent) {
		// 密码加密处理
		passwordAgentHelper.encryptPassword(agent);	
		System.out.println("agent.getLoginName()"+agent.getLoginName());
		//添加代理
		agentDao.addAgent(agent);
	}
	
	/**
	 * 	通过登录名查询代理详细信息
	 * @param name 登录名
	 * @return 代理详细信息
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Agent getAgentByName(String loginName) {
		if (loginName == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		return agentDao.getAgentByName(loginName);
	}
	
	/**
	 * 	通过代理id查询代理详细信息 
	 * @param id 代理id
	 * @return 代理
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Agent getAgentById(Long id) {
		if (id == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		return agentDao.getAgentById(id);
	}
	
	/**
	 *	 检查登录名是否已被注册
	 * @param queryMap
	 */
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
