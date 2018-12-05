package com.thinkingFruit.client.service.impl;

import java.util.ArrayList;
import java.util.List;
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
import com.ysdevelop.common.utils.Constant;

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
		if(agent.getInviterId()==Constant.DEFALULT_ZERO_INT) {
			agent.setInviterUpperId(0L);
		}else {
			Agent agentById = agentDao.getAgentById(agent.getInviterId());
			agent.setInviterUpperId(agentById.getInviterId());
		}
		Integer addAgent=agentDao.addAgent(agent);
		Integer addAgentAddress=agentDao.addAgentAddress(agent.getId());
		
		if(addAgent==Constant.DEFALULT_ZERO_INT||addAgentAddress==Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.REGISTER_FAIL);
		}
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
	
	/**
	 * 	检查代理信息是否完善
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void checkInformation(Long id) {
		Agent agentById = agentDao.getAgentById(id);
		
		if(id==null) {
			throw new WebServiceException(CodeMsg.MEMBER_NOREGISTER);
		}else {
			if(agentById==null) {
				throw new WebServiceException(CodeMsg.SERVER_ERROR);
			}else if(agentById.getName()==null||"".equals(agentById.getName())||agentById.getName().isEmpty()){
				throw new WebServiceException(CodeMsg.INFORMATION_NOT_NULL);
			}
		}
		
	}
	
	/**
	 * 	修改/完善个人信息
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void updateInformation(Agent agent) {
		if (agent == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		Integer update= agentDao.updateInformation(agent);
		if(update==Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.INFORMATION_UPDATE_ERROR);
		}
	}
	/**
	 * 团队列表
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public List<Agent> agentList(Long id){
		Agent agentById = agentDao.getAgentById(id);
		Long teamNumbers = agentDao.getTeamNumbers(id);
		System.out.println("teamNumbers:"+teamNumbers);
		Double teamSales = agentDao.getTeamSales(id);
		System.out.println("teamSales:"+teamSales);
		agentById.setTeamSales(teamSales);
		agentById.setTeamNumbers(teamNumbers);
		List<Agent> agentList=new ArrayList<>();
		agentList.add(agentById);
		agentList.addAll(agentDao.findAgentList(id));
		return agentList;
	}
	/**
	* 寻找邀请人
	*/
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Agent getInvite(Long id) {
		Agent agent =agentDao.findinvite(id);
		return agent;
	}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Agent getAgentAddress(Long memberId) {
		Agent agent=agentDao.getAgentAddress(memberId);
		return agent;
	}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void updateAgentAddress(Agent agent) {
		Integer updateAgentAddress=agentDao.updateAgentAddress(agent);
		if(updateAgentAddress==Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.ADDRESS_UPDATE_ERROR);
		}
	}

}
