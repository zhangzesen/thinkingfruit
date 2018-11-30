package com.thinkingFruit.client.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkingFruit.client.entity.Agent;
import com.thinkingFruit.client.helper.PasswordAgentHelper;
import com.thinkingFruit.client.service.AgentService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.HttpUtils;

@Controller
@RequestMapping(value="/agent")
public class AgentController {
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	PasswordAgentHelper passwordAgentHelper;
	
	/**
	 *首页跳转
	 * */
	@RequestMapping(value="/register",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String register(){
		return "user/register";
	}
	
	/** 用户登录 **/
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Result<String> doLogin(HttpServletRequest request, Agent agent) {
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		String randCode = queryMap.get("randCode");
		String randCodeValidate = (String) request.getSession().getAttribute("randCode");
		if (randCodeValidate == null || !randCodeValidate.equalsIgnoreCase(randCode)) {
			throw new WebServiceException(CodeMsg.CODE_VALIDATE);
		}
		Agent agentByName = agentService.getAgentByName(agent.getLoginName());
		if(!passwordAgentHelper.checkPassword(agentByName, agent.getPswd())) {
			throw new WebServiceException(CodeMsg.PASSWORD_WRONG);
		}
		HttpSession session = request.getSession();
		session.setAttribute("agentId", agentByName.getId());
		return Result.success("登录成功");
	}
	
	/** 用户注册 **/
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Result<String> register(HttpServletRequest request, Agent agent) {
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		String randCode = queryMap.get("randCode");
		String randCodeValidate = (String) request.getSession().getAttribute("randCode");
		if (randCodeValidate == null || !randCodeValidate.equalsIgnoreCase(randCode)) {
			throw new WebServiceException(CodeMsg.CODE_VALIDATE);
		}
		System.out.println("注册getLoginName()==="+agent.getLoginName());
		agentService.checkName(queryMap);
		agentService.addAgent(agent);
		return Result.success("注册成功");
	}
}