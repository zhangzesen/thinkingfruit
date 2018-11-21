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
	@RequestMapping(value = "/pagination", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String pagination(HttpServletRequest request,Pagination<Commision> pagination){
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		commisionService.paginationCommision(pagination,queryMap);
		return JSONHelper.bean2json(Result.successPaginationData(pagination.getItems(), pagination.getTotalItemsCount()));
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
	 *个人用户佣金表
	 * @return
	 */
	@RequestMapping(value = "/person/pagination", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String paginationPerson(HttpServletRequest request,Pagination<Commision> pagination){
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		commisionService.paginationCommisionPerson(pagination,queryMap);
		System.out.println("个人佣金--》"+JSONHelper.bean2json(Result.successPaginationData(pagination.getItems(), pagination.getTotalItemsCount())));
		return JSONHelper.bean2json(Result.successPaginationData(pagination.getItems(), pagination.getTotalItemsCount()));
	}
}
