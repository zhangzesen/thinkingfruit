package com.thinkingFruit.admin.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkingFruit.admin.entity.Commision;
import com.thinkingFruit.admin.service.CommisionService;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.HttpUtils;
import com.ysdevelop.common.utils.JSONHelper;


@Controller
@RequestMapping(value="commision")
public class CommisionController {
	
	@Autowired
	CommisionService commisionService;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String index(){
		return "commision/index";
	}
	
	@RequestMapping(value = "/info", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String set(){
		return "commision/info";
	}
	
	@RequestMapping(value = "/pagination", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String pagination(HttpServletRequest request,Pagination<Commision> pagination){
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		commisionService.paginationCommision(pagination,queryMap);
		return JSONHelper.bean2json(Result.successPaginationData(pagination.getItems(), pagination.getTotalItemsCount()));
	}
	
	@RequestMapping(value = "/message", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String message(@RequestParam(value = "id", required = false) Long id){
		Commision commisionReplace = commisionService.findCommisionById(id);
		return JSONHelper.bean2json(Result.successData(commisionReplace));
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String indexPerson(){
		return "commisionPerson/index";
	}
	
	@RequestMapping(value = "/person/pagination", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String paginationPerson(HttpServletRequest request,Pagination<Commision> pagination){
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		commisionService.paginationCommisionPerson(pagination,queryMap);
		return JSONHelper.bean2json(Result.successPaginationData(pagination.getItems(), pagination.getTotalItemsCount()));
	}
}
