package com.thinkingFruit.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.thinkingFruit.admin.entity.CommissionRatio;
import com.thinkingFruit.admin.entity.News;
import com.thinkingFruit.admin.service.NewsService;
import com.thinkingFruit.admin.service.SiteService;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.result.Results;
import com.ysdevelop.common.utils.HttpUtil;
import com.ysdevelop.common.utils.JSONHelper;

/**
 * @author zhangzesen
 *
 * @date 2018年11月23日
 *
 * @package com.thinkingFruit.admin.controller
 *
 * @description 设置：分佣/邀请比例设置
 */
@Controller
@RequestMapping(value="/site")
public class SiteController {
	@Autowired
	SiteService siteService;
	@Autowired
	NewsService newsService;
	/**
	 * 	跳到订单首页
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String orderIndex(){
		return "site/index";
	}
	/**
	 * 跳到关于我们
	 * @return
	 */
	@RequestMapping(value = "about", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String about(){
		return "about/set";
	}
	/**
	 *添加关于我们
	 * @return
	 */
	@RequestMapping(value = "addAbout", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<String> addNews(@Valid News news){
		newsService.addAbout(news);
		return Result.success("添加成功");
	}
	/**
	 * 查找关于我们
	 * @return
	 */
	@RequestMapping(value = "/findAbout", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findAbout(){
		News news = newsService.findAbout();
		return JSONHelper.bean2json(Result.successData(news));
	}
	/**
	 * 修改关于我们信息
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<String> edit(@Valid News news){
		newsService.editAbout(news);
		return Result.success("更改成功");
	}
	/**
	 * 	获取订单分页
	 * @param request
	 * @return 订单集合
	 */
	@RequestMapping(value = "/pagination", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody
	public Results<List<CommissionRatio>> pagination(HttpServletRequest request){		
		Map<String, String> queryMap = HttpUtil.getParameterMap(request);
		PageInfo<CommissionRatio> pageInfo =siteService.paginationOrder(queryMap);
		return Results.successPaginationData(pageInfo.getList(), pageInfo.getTotal());
	}
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
	@RequestMapping(value = "/set", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String info(){
		return "site/set";
	}
	
	/**
	 * 通过id查看详情
	 * */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody
	public Results<CommissionRatio> info(@PathVariable(value = "id") Long id) {
		CommissionRatio commissionRatio = siteService.getById(id);
		return Results.successData(commissionRatio);
	}
	
	/**
	 * 修改比例
	 * @param commissionRatio
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
	@ResponseBody
	public Results<String> update(@Valid CommissionRatio commissionRatio) {
		siteService.update(commissionRatio);
		return Results.success("修改成功");
	}
}
