package com.thinkingFruit.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.thinkingFruit.admin.entity.Commision;
import com.thinkingFruit.admin.service.CommisionRankingService;
import com.ysdevelop.common.result.Results;
import com.ysdevelop.common.utils.HttpUtil;

@Controller
@RequestMapping(value="ranking")
public class CommisionRankingController {
	/**
	 * @author wulei
	 *
	 * @date 2018年11月21日
	 *
	 * @package com.thinkingFruit.admin.controller
	 *
	 * @description 佣金排名
	 */
	
	@Autowired
	CommisionRankingService commisionRankingService;
	/**
	 * 跳转index
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String CommisionRanking(){
		return "commisionRanking/index";
	}
	/**
	 * 佣金排名表
	 * @return
	 */
	@RequestMapping(value="/pagination",method=RequestMethod.GET,produces = "application/json;charset=utf-8")
	@ResponseBody
	public Results<List<Commision>> pagination(HttpServletRequest request){
		Map<String, String> queryMap = HttpUtil.getParameterMap(request);
		PageInfo<Commision> pageInfo= commisionRankingService.paginationCommision(queryMap);
		return Results.successPaginationData(pageInfo.getList(), pageInfo.getTotal());
	}
	
}
