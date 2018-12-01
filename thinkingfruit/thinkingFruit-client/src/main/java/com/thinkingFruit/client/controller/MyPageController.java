package com.thinkingFruit.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkingFruit.client.entity.Agent;
import com.thinkingFruit.client.service.AgentService;
import com.ysdevelop.common.result.Results;

@Controller
@RequestMapping(value="/my")
public class MyPageController {
	
	@Autowired
	private AgentService agentService;
	
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
	@RequestMapping(value="/adress",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String adress(){
		return "my/adress";
	}
	/**
	 *跳转地址页面
	 * */
	@RequestMapping(value="/about",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String about(){
		return "my/about";
	}
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<String> update(Agent agent){
		agentService.updateInformation(agent);
		return Results.success("信息修改成功");
	}
}
