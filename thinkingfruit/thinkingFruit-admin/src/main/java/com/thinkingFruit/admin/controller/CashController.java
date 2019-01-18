package com.thinkingFruit.admin.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkingFruit.admin.entity.Cash;
import com.thinkingFruit.admin.service.CashService;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.HttpUtils;
import com.ysdevelop.common.utils.JSONHelper;


/**
 * 
 * @author wulei
 *
 * @Package com.ysdevelop.smurfs.admin.controller
 *
 * @Description TODO
 *
 * @date 2018年6月15日
 *
 * @version
 *
 */

@Controller
@RequestMapping(value="cash")
public class CashController {
	
	@Autowired
	CashService cashService;
	
	@RequestMapping(value="", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String CashIndex(){
		return "cash/index";
	}
	
	@RequestMapping(value = "/pagination", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String pagination(HttpServletRequest request,Pagination<Cash> pagination){
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		cashService.paginationCash(pagination,queryMap);
		return JSONHelper.bean2json(Result.successPaginationData(pagination.getItems(), pagination.getTotalItemsCount()));
	}
	
	@RequestMapping(value = "/set", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<String> set(@RequestParam(value = "id", required = false) Long id){
		cashService.editCash(id);
		return Result.success("提现成功");
	}
}
