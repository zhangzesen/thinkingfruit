package com.thinkingFruit.client.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkingFruit.client.entity.Agent;
import com.thinkingFruit.client.entity.ClientCommision;
import com.thinkingFruit.client.entity.ClientNews;
import com.thinkingFruit.client.service.AgentService;
import com.thinkingFruit.client.service.ClientCommisionService;
import com.thinkingFruit.client.service.ClientNewsService;
import com.ysdevelop.common.result.Results;

@Controller
@RequestMapping(value="/my")
public class MyPageController {
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private ClientCommisionService clientCommisionService;
	
	@Autowired
	ClientNewsService clientNewsService;
	
	/**
	 *首页跳转
	 * */
	@RequestMapping(value="",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String register(){
		return "my/index";
	}
	
	/**
	 *	信息完善页面跳转
	 * */
	@RequestMapping(value="/information",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String information(){
		return "my/information";
	}
	/**
	 *跳转地址页面
	 * */
	@RequestMapping(value="/address",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String adress(){
		return "my/address";
	}
	/**
	 *跳转关于页面
	 * */
	@RequestMapping(value="/about",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String about(){
		return "my/about";
	}
	/**
	 * 个人头部信息
	 * @param agent 代理
	 * @return
	 */
	@RequestMapping(value = "/info", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<Agent> info(HttpServletRequest request){
		HttpSession session = request.getSession();
		Long id = (Long)session.getAttribute("agentId");
		Agent agent=agentService.findInfo(id);
		System.out.println("11111111111111"+agent.getName());
		return Results.successData(agent);
	}
	//头部团队信息
	@RequestMapping(value = "/teamInfo", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<Agent> teamInfo(HttpServletRequest request){
		HttpSession session = request.getSession();
		Long id = (Long)session.getAttribute("agentId");
		Agent agent=agentService.teamAgent(id);
		return Results.successData(agent);
	}
	//头部推广费信息
	@RequestMapping(value = "/commisionInfo", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<ClientCommision> commisionInfo(HttpServletRequest request){
		HttpSession session = request.getSession();
		Long id = (Long)session.getAttribute("agentId");
		ClientCommision ClientCommision =clientCommisionService.getTotalCost(id);
		return Results.successData(ClientCommision);
	}
	/**
	 * 修改完善信息
	 * @param agent 代理
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<String> update(@Valid Agent agent){
		agentService.updateInformation(agent);
		return Results.success("信息修改成功");
	}
	/**
	 * 用户升级申请
	 * @param agent 代理
	 * @return
	 */
	@RequestMapping(value = "/upLevel", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<String> upLevel(HttpServletRequest request){
		HttpSession session = request.getSession();
		Long id = (Long)session.getAttribute("agentId");
		agentService.updateUpLevel(id);
		return Results.success("信息修改成功");
	}
	/**
	 * 通过查找关于我们
	 * */
	@RequestMapping(value = "/findAbout", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<ClientNews> findAbout(){
		ClientNews findNewsById = clientNewsService.about();
		return Results.successData(findNewsById);
	}
	/**
	 * 退出
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/loginOut", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<String> loginOut(HttpServletRequest request ,HttpServletResponse response){
		HttpSession session = request.getSession();
		session.invalidate();
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
		return Results.success("用户退出成功");
	}
}
