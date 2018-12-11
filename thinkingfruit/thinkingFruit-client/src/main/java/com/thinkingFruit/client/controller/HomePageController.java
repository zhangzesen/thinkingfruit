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

/**
 * @author zhangzesen
 *
 * @date 2018年11月30日
 *
 * @package com.thinkingFruit.client.controller
 *
 * @description 首页(home,商品)
 */
@Controller
@RequestMapping(value="/home")
public class HomePageController {
	
	@Autowired
	ClientCommodityService clientCommodityService;
	
	@Autowired
	PurchaseOrderService purchaseOrderService;
	
	/**
	 *	首页跳转
	 */
	@RequestMapping(value="",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String register(){
		return "home/index";
	}
	
	/**
	 * 	查看所有商品
	 * @return 所有商品
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<List<ClientCommodity>> list(){
		List<ClientCommodity> clientCommodityList = clientCommodityService.ClientCommodityList();
		return Results.successData(clientCommodityList);
	}
	/**
	 * 	查出所有轮播图
	 * @return 所有轮播图图片
	 */
	@RequestMapping(value = "/imgList", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<List<ClientCommodity>> imgList(){
		List<ClientCommodity> imgList = clientCommodityService.fingImgList();
		return Results.successData(imgList);
	}
	/**
	 * 	跳转到详情页
	 * @return
	 */
	@RequestMapping(value="/info",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String info(){
		return "home/info";
	}
	
	/**
	 * 	获取商品详情
	 * @param request
	 * @param id 商品id
	 * @return 商品
	 */
	@RequestMapping(value = "/details", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<ClientCommodity> details(HttpServletRequest request,Long id){
		ClientCommodity findCommodityById = clientCommodityService.findCommodityById(request,id);
		return Results.successData(findCommodityById);
	}
	
	/**
	 * 	购买商品
	 * @param request
	 * @param clientPurchaseOrder 商品交易订单
	 * @return
	 */
	@RequestMapping(value = "/purchase", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<String> purchase(HttpServletRequest request,ClientPurchaseOrder clientPurchaseOrder){
		purchaseOrderService.addPurchaseOrder(request,clientPurchaseOrder);
		return Results.success("商品购买成功");
	}
}
