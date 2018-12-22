package com.thinkingFruit.client.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkingFruit.client.entity.ClientAddress;
import com.thinkingFruit.client.entity.ClientDepot;
import com.thinkingFruit.client.entity.ClientOrder;
import com.thinkingFruit.client.service.ClientOrderService;
import com.ysdevelop.common.result.Results;

@Controller
@RequestMapping(value="/order")
public class OrderController {

	@Autowired
	private ClientOrderService clientOrderService;
	/**
	 *仓库首页跳转
	 * */
	@RequestMapping(value="depot",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String dopet(){
		return "order/index";
	}
	/**
	 *提货页面跳转跳转
	 * */
	@RequestMapping(value="extract",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String extract(){
		return "order/extract";
	}
	/**
	 *云仓库详情
	 * */
	@RequestMapping(value = "/depotList", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<List<ClientDepot>> list(HttpServletRequest request){
		HttpSession session = request.getSession();
		Long id = (Long)session.getAttribute("agentId");
		List<ClientDepot> clientDepot = clientOrderService.depotList(id);
		return Results.successData(clientDepot);
	}
	/**
	 *订单详情
	 * */
	@RequestMapping(value = "/orderList", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<List<ClientOrder>> orderList(HttpServletRequest request){
		HttpSession session = request.getSession();
		Long id = (Long)session.getAttribute("agentId");
		List<ClientOrder> ClientOrderList = clientOrderService.orderList(id);
		return Results.successData(ClientOrderList);
	}
	/**
	 *发货信息查询
	 * */
	@RequestMapping(value = "/extractInfo", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<ClientAddress> extractInfo(HttpServletRequest request){
		HttpSession session = request.getSession();
		Long memberId = (Long)session.getAttribute("agentId");
		ClientAddress ClientAddress = clientOrderService.extractList(memberId);
		return Results.successData(ClientAddress);
	}
	/**
	 * 订单列表
	 * */
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<String> needList(HttpServletRequest request,ClientOrder clientOrder){
		HttpSession session = request.getSession();
		Long memberId = (Long)session.getAttribute("agentId");
		clientOrderService.sendOrder(clientOrder,memberId);
		return Results.success("订单请求发货成功");
	}
}
