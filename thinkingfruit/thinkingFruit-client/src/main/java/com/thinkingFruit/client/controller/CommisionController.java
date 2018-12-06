package com.thinkingFruit.client.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkingFruit.client.entity.ClientCommision;
import com.thinkingFruit.client.service.ClientCommisionService;
import com.ysdevelop.common.result.Results;

@Controller
@RequestMapping(value="/commision")
public class CommisionController {
	
	@Autowired
	private ClientCommisionService ClientCommisionService;
	/**
	 *佣金首页跳转
	 * */
	@RequestMapping(value="",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String register(){
		return "commision/index";
	}
	/**
	 *佣金详情
	 * */
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<List<ClientCommision>> orderList(HttpServletRequest request){
		HttpSession session = request.getSession();
		Long id = (Long)session.getAttribute("agentId");
		List<ClientCommision> ClientCommisionList = ClientCommisionService.ClientCommisionList(id);
		return Results.successData(ClientCommisionList);
	}
}
