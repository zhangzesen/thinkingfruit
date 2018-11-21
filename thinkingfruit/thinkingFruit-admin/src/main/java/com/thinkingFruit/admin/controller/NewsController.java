package com.thinkingFruit.admin.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkingFruit.admin.entity.News;
import com.thinkingFruit.admin.service.NewsService;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.HttpUtils;
import com.ysdevelop.common.utils.JSONHelper;

@Controller
@RequestMapping(value="news")
public class NewsController {
	
	@Autowired
	NewsService newsService;
	
	//跳转到新闻列表
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String newsIndex() {
		return "news/index";
	}
	
	//跳转到新闻列表
	@RequestMapping(value = "/set", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String set() {
		return "news/set";
	}
	
	//获取数据(包括查询)
	@RequestMapping(value = "/pagination", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String pagination(HttpServletRequest request,Pagination<News> pagination){
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		newsService.paginationNews(pagination,queryMap);
		return JSONHelper.bean2json(Result.successPaginationData(pagination.getItems(), pagination.getTotalItemsCount()));
	}
	
	//删除新闻
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<String> deleteNews(@RequestParam(value = "id", required = false)Long id){
		newsService.deleteNews(id);
		return Result.success("删除成功");
	}
	
	//添加新闻
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<String> addNews(@Valid News news){
		newsService.addNews(news);
		return Result.success("添加成功");
	}
	
	//根据id查询新闻信息
	@RequestMapping(value = "/info", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String info(@RequestParam(value = "id", required = false)Long id){
		News news = newsService.findNewsById(id);
		return JSONHelper.bean2json(Result.successData(news));
	}
	
	//修改新闻信息
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<String> edit(@Valid News news){
		newsService.editNews(news);
		return Result.success("修改成功");
	}
	
}
