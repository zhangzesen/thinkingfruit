package com.thinkingFruit.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkingFruit.admin.entity.Commodity;
import com.thinkingFruit.admin.service.CommodityService;
import com.ysdevelop.common.result.Result;

@Controller
@RequestMapping(value="/home")
public class HomePageController {
	
	@Autowired
	CommodityService commodityService;
	/**
	 *首页跳转
	 * */
	@RequestMapping(value="",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String register(){
		return "home/index";
	}
	
	/**
	 * 获取index的商品列表
	 * */
	@RequestMapping(value = "/list", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Result<List<Commodity>> list() {
		List<Commodity> clientListCommodity = commodityService.clientListCommodity();
		return Result.successData(clientListCommodity);
	}
}
