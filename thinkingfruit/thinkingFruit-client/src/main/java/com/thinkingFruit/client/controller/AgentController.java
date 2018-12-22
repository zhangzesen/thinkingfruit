package com.thinkingFruit.client.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import com.ysdevelop.common.result.Results;
import com.ysdevelop.common.utils.Constant;
import com.ysdevelop.common.utils.HttpUtils;

/**
 * @author zhangzesen
 *
 * @date 2018年11月30日
 *
 * @package com.thinkingFruit.client.controller
 *
 * @description 代理
 */
@Controller
@RequestMapping(value="/agent")
public class AgentController {
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	PasswordAgentHelper passwordAgentHelper;
	
	/**
	 *跳转到注册
	 * */
	@RequestMapping(value="/register",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String register(){
		return "user/register";
	}
	
	/**
	 * 跳转到登录
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	/**
	 *跳转团队界面
	 */
	@RequestMapping(value="/team",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String agents(){
		return "team/index";
	}
	/**
	 * 	用户登录
	 * @param request
	 * @param agent 代理
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST , produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<String> doLogin(HttpServletRequest request, Agent agent) {
		//判断验证码
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		String randCode = queryMap.get("randCode");
		String randCodeValidate = (String) request.getSession().getAttribute("randCode");
		if (randCodeValidate == null || !randCodeValidate.equalsIgnoreCase(randCode)) {
			throw new WebServiceException(CodeMsg.CODE_VALIDATE);
		}
		//通过登录名获取代理信息
		Agent agentByName = agentService.getAgentByName(agent.getLoginName());
		if(agentByName==null) {
			throw new WebServiceException(CodeMsg.UNREGISTERED);
		}
		if(agentByName.getStatus()==Constant.DEFALULT_ZERO_INT) {
			throw new WebServiceException(CodeMsg.REGISTER_UNAUDITED);
		}
		if(!passwordAgentHelper.checkPassword(agentByName, agent.getPswd())) {
			throw new WebServiceException(CodeMsg.PASSWORD_WRONG);
		}
		
		//存放入session域中
		HttpSession session = request.getSession();
		session.setAttribute("agentId", agentByName.getId());
		return Result.success("登录成功");
	}
	
	/**
	 * 	用户注册
	 * @param request
	 * @param agent 代理
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<String> register(HttpServletRequest request, Agent agent) {
		//判断验证码
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		String randCode = queryMap.get("randCode");
		String randCodeValidate = (String) request.getSession().getAttribute("randCode");
		if (randCodeValidate == null || !randCodeValidate.equalsIgnoreCase(randCode)) {
			throw new WebServiceException(CodeMsg.CODE_VALIDATE);
		}
		System.out.println("注册getLoginName()==="+agent.getLoginName());
		//查看登录名是否存在
		agentService.checkName(queryMap);
		//添加代理
		agentService.addAgent(agent);
		return Result.success("注册成功");
	}
	/**
	 * 个人信息
	 * */
	@RequestMapping(value = "/information", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<Agent> information(HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("agentId"+session.getAttribute("agentId"));
		Agent agentById = agentService.getAgentById((Long)session.getAttribute("agentId"));
		return Result.successData(agentById);
	}
	/**
	 * 团队列表
	 * */
	@RequestMapping(value = "/teamList", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<List<Agent>> list(HttpServletRequest request){
		HttpSession session = request.getSession();
		Long id = (Long)session.getAttribute("agentId");
		System.out.println("id--->"+id);
		List<Agent> agentList = agentService.agentList(id);
		return Results.successData(agentList);
	}
	/**
	 * 代理信息
	 * @param request
	 * @return 在团队中我的代理信息
	 */
	@RequestMapping(value = "/teamAgent", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<Agent> teamAgent(HttpServletRequest request){
		HttpSession session = request.getSession();
		Long id = (Long)session.getAttribute("agentId");
		Agent agent= agentService.teamAgent(id);
		return Results.successData(agent);
	}
	/**
	 * 查看邀请者
	 * */
	@RequestMapping(value = "/inviter", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<Agent> inviter(HttpServletRequest request){
		HttpSession session = request.getSession();
		Long id = (Long)session.getAttribute("agentId");
		Agent agentById = agentService.getAgentById(id);
		Agent agent = agentService.getInviter(agentById.getInviterId());
		return Result.successData(agent);
	}
	
	/**
	 * 注册添加空地址
	 * @param request
	 * @return 地址信息
	 */
	@RequestMapping(value = "/address", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<Agent> address(HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("agentId"+session.getAttribute("agentId"));
		Agent getAgentAddress=agentService.getAgentAddress((Long)session.getAttribute("agentId"));
		return Result.successData(getAgentAddress);
	}
	
	/**
	 * 修改地址信息
	 * @param agent 代理
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<String> update(@Valid Agent agent){
		agentService.updateAgentAddress(agent);
		return Results.success("信息修改成功");
	}
}
