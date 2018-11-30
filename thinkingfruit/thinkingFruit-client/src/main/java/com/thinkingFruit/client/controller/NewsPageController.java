package com.thinkingFruit.client.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkingFruit.client.entity.ClientCommodity;
import com.thinkingFruit.client.entity.ClientNews;
import com.thinkingFruit.client.service.ClientNewsService;
import com.ysdevelop.common.result.Results;

@Controller
@RequestMapping(value="/news")
public class NewsPageController {
	
	@Autowired
	ClientNewsService clientNewsService;
	/**
	 *首页跳转
	 * */
	@RequestMapping(value="",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String index(){
		return "news/index";
	}
	/**
	 *详情页跳转
	 * */
	@RequestMapping(value="info",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String info(){
		return "news/info";
	}
	/**
	 * 新闻列表
	 * */
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<List<ClientNews>> list(){
		List<ClientNews> clientNewsList = clientNewsService.ClientNewsList();
		return Results.successData(clientNewsList);
	}
	/**
	 * 通过id查找新闻详情
	 * */
	@RequestMapping(value = "/details", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<ClientNews> details(HttpServletRequest request,Long id){
		ClientNews findNewsById = clientNewsService.findNewsById(request,id);
		
		return Results.successData(findNewsById);
	}
}
