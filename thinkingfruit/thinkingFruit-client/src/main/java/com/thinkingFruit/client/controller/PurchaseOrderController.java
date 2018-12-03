package com.thinkingFruit.client.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkingFruit.client.entity.ClientPurchaseOrder;
import com.thinkingFruit.client.service.PurchaseOrderService;
import com.ysdevelop.common.result.Results;

@Controller
@RequestMapping(value="/purchaseOrder")
public class PurchaseOrderController {
	@Autowired
	private PurchaseOrderService purchaseOrderService;
	/** 
	 *订单首页跳转
	 * */
	@RequestMapping(value="",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String register(){
		return "purchaseOrder/index";
	}
	/**
	 * 订单列表
	 * */
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<List<ClientPurchaseOrder>> list(HttpServletRequest request){
		HttpSession session = request.getSession();
		Long id = (Long)session.getAttribute("agentId");
		List<ClientPurchaseOrder> PurchaseOrderList = purchaseOrderService.purchaseOrderList(id);
		return Results.successData(PurchaseOrderList);
	}
}
