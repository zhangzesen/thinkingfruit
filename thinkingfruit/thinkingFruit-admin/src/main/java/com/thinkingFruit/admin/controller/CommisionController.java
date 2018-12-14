package com.thinkingFruit.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.thinkingFruit.admin.entity.Commision;
import com.thinkingFruit.admin.service.CommisionService;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.result.Results;
import com.ysdevelop.common.utils.HttpUtil;
import com.ysdevelop.common.utils.HttpUtils;
import com.ysdevelop.common.utils.JSONHelper;
/**
 * @author wulei
 *
 * @date 2018年11月21日
 *
 * @package com.thinkingFruit.admin.controller
 *
 * @description 佣金
 */

@Controller
@RequestMapping(value="commision")
public class CommisionController {
	
	@Autowired
	CommisionService commisionService;
	/**
	 *页面跳转佣金index
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String index(){
		return "commision/index";
	}
	/**
	 *页面跳转佣金info
	 * @return
	 */
	@RequestMapping(value = "/info", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String set(){
		return "commision/info";
	}
	/**
	 *遍历数据库并产生表
	 * @return
	 */
	@RequestMapping(value="/pagination",method=RequestMethod.GET,produces = "application/json;charset=utf-8")
	@ResponseBody
	public Results<List<Commision>> pagination(HttpServletRequest request){
		Map<String, String> queryMap = HttpUtil.getParameterMap(request);
		PageInfo<Commision> pageInfo= commisionService.paginationCommision(queryMap);
		return Results.successPaginationData(pageInfo.getList(), pageInfo.getTotal());
	}
	/**
	 *通过ID查询信息
	 * @return
	 */
	@RequestMapping(value = "/message", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String message(@RequestParam(value = "id", required = false) Long id){
		Commision commisionReplace = commisionService.findCommisionById(id);
		return JSONHelper.bean2json(Result.successData(commisionReplace));
	}
	/**
	 *个人用户佣金跳转index
	 * @return
	 */
	@RequestMapping(value = "/person", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String indexPerson(){
		return "commisionPerson/index";
	}
	/**
	 *遍历个人佣金并产生表
	 * @return
	 */
	@RequestMapping(value="/person/pagination",method=RequestMethod.GET,produces = "application/json;charset=utf-8")
	@ResponseBody
	public Results<List<Commision>> personPagination(HttpServletRequest request){
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		PageInfo<Commision> pageInfo= commisionService.personCommision(queryMap);
		return Results.successPaginationData(pageInfo.getList(), pageInfo.getTotal());
	}
}
