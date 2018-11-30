package com.thinkingFruit.client.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkingFruit.client.entity.ClientCommodity;
import com.thinkingFruit.client.entity.ClientPurchaseOrder;
import com.thinkingFruit.client.service.ClientCommodityService;
import com.thinkingFruit.client.service.PurchaseOrderService;
import com.ysdevelop.common.result.Results;

@Controller
@RequestMapping(value="/home")
public class HomePageController {
	
	@Autowired
	ClientCommodityService clientCommodityService;
	
	@Autowired
	PurchaseOrderService purchaseOrderService;
	
	/**
	 *首页跳转
	 * */
	@RequestMapping(value="",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String register(){
		return "home/index";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<List<ClientCommodity>> list(){
		List<ClientCommodity> clientCommodityList = clientCommodityService.ClientCommodityList();
		return Results.successData(clientCommodityList);
	}
	
	@RequestMapping(value="/info",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String info(){
		return "home/info";
	}
	
	@RequestMapping(value = "/details", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<ClientCommodity> details(HttpServletRequest request,Long id){
		ClientCommodity findCommodityById = clientCommodityService.findCommodityById(request,id);
		return Results.successData(findCommodityById);
	}
	
	@RequestMapping(value = "/purchase", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<ClientCommodity> purchase(HttpServletRequest request,ClientPurchaseOrder clientPurchaseOrder){
		purchaseOrderService.addPurchaseOrder(request,clientPurchaseOrder);
		return Results.success("商品购买成功");
	}
}
