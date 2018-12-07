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
	 * 	向上级购买订单列表
	 * @param request
	 * @return 上级购买订单列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<List<ClientPurchaseOrder>> list(HttpServletRequest request){
		HttpSession session = request.getSession();
		Long id = (Long)session.getAttribute("agentId");
		List<ClientPurchaseOrder> PurchaseOrderList = purchaseOrderService.purchaseOrderList(id);
		return Results.successData(PurchaseOrderList);
	}
	/**
	 * 	下级向我购买订单列表
	 * @param request
	 * @return 下级向我购买订单列表
	 */
	@RequestMapping(value = "/needList", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<List<ClientPurchaseOrder>> needList(HttpServletRequest request){
		HttpSession session = request.getSession();
		Long id = (Long)session.getAttribute("agentId");
		List<ClientPurchaseOrder> purchaseOrderNeedList = purchaseOrderService.purchaseOrderNeedList(id);
		return Results.successData(purchaseOrderNeedList);
	}
	
	/**
	 * 	确认购买订单发货
	 * @param request
	 * @param orderNo 订单号
	 * @return
	 */
	@RequestMapping(value = "/confirm", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<String> confirm(HttpServletRequest request,String orderNo){
		purchaseOrderService.confirmPurchaseOrder(request,orderNo);
		return Results.success("发货成功");
	}
	
	/**
	 * 	取消向上级购买订单
	 * @param orderNo 订单号
	 * @return
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<String> cancel(String orderNo){
		purchaseOrderService.cancelPurchaseOrder(orderNo);
		return Results.success("取消订单成功");
	}
}
