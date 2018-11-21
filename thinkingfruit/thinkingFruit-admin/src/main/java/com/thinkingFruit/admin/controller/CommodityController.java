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
import com.thinkingFruit.admin.entity.Commodity;
import com.thinkingFruit.admin.service.CommodityService;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.result.Results;
import com.ysdevelop.common.utils.HttpUtils;
import com.ysdevelop.common.utils.JSONHelper;


/**
 * @author zhangzesen
 *
 * @date 2018年11月17日
 *
 * @package com.thinkingFruit.admin.controller
 *
 * @description 商品
 */
@Controller
@RequestMapping(value="/commodity")
public class CommodityController {
	
	@Autowired
	CommodityService commodityService;
	
	/**
	 * 	跳转到商品列表
	 * @return 商品首页
	 */
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String commodityIndex() {
		return "commodity/index";
	}
	
	/**
	 * 	获取数据(包括查询)
	 * @param request
	 * @param pagination
	 * @return 所有商品分页
	 */
	@RequestMapping(value = "/pagination", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<List<Commodity>> pagination(HttpServletRequest request){
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		PageInfo<Commodity> pageInfo=commodityService.paginationCommodity(queryMap);
		return Results.successPaginationData(pageInfo.getList(), pageInfo.getTotal());
	}
	
	/**
	 * 	跳转到添加界面
	 * @return 商品添加/修改界面
	 */
	@RequestMapping(value = "/set", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String set() {
		return "commodity/set";
	}
	
	/**
	 * 	修改商品信息
	 * @param commodity 商品
	 * @return 修改成功返回到index界面
	 */
	@RequestMapping(value = "/edit",method = RequestMethod.PUT,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Result<String> edit(Commodity commodity){
		commodityService.editCommodity(commodity);
		return Result.success("修改成功");
	}
	
	/**
	 * 	添加商品
	 * @param commodity 商品
	 * @return 添加成功返回到index界面
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<String> add(Commodity commodity){
		commodityService.addCommodity(commodity);
		return Result.success("添加成功");
	}
	
	/**
	 * 	跳转到商品信息界面
	 * @return 商品详情界面
	 */
	@RequestMapping(value = "/message",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
	public String message(){
		return "commodity/info";
	}
	
	/**
	 * 	根据id查询出详细信息
	 * @param id 商品id
	 * @return 返回商品详情
	 */
	@RequestMapping(value = "/info", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String info(Long id){
		Commodity commodityInfo = commodityService.findCommodityById(id);
		return JSONHelper.bean2json(Result.successData(commodityInfo));
	}
	
	/**
	 * 	删除商品
	 * @param id 商品id
	 * @return 删除成功返回到index界面
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<String> del(@RequestParam(value = "id", required = false) Long id){
		commodityService.deleteCommodityById(id);
		return Result.success("删除成功");
	}
	
	
}
