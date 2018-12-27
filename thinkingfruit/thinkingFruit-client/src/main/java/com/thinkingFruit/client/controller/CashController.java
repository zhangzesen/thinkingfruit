package com.thinkingFruit.client.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkingFruit.client.entity.Agent;
import com.thinkingFruit.client.entity.Cash;
import com.thinkingFruit.client.service.AgentService;
import com.thinkingFruit.client.service.CashService;
import com.ysdevelop.common.result.Result;

/**
 * @author zhangzesen
 *
 * @date 2018年12月5日
 *
 * @package com.thinkingFruit.client.controller
 *
 * @description 提现
 */
@Controller
@RequestMapping(value="/cash")
public class CashController {
	
	@Autowired
	CashService cashService;
	@Autowired
	private AgentService agentService;
	
	/**
	 *提现首页跳转
	 * */
	@RequestMapping(value="",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String register(){
		return "cash/index";
	}
	
	/**
	 * 提现列表
	 * @return
	 */
	@RequestMapping(value="/cashList",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String cashList(){
		return "cash/cashList";
	}
	
	/**
	 * 插入提现记录
	 * @param request
	 * @param cash 提现实体类
	 * @return
	 */
	@RequestMapping(value = "/withdrawal", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<String> withdrawal(HttpServletRequest request,@Valid Cash cash) {
		HttpSession session = request.getSession();
		cash.setMemberId((Long)session.getAttribute("agentId"));
		cashService.withdrawal(cash);
		return Result.success("提现发起成功，等待公司处理");
	}
	/**
	 * 查询余额
	 * @param request
	 * @return 余额
	 */
	@RequestMapping(value="/balance",method=RequestMethod.GET,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<Agent> balance(HttpServletRequest request){
		HttpSession session = request.getSession();
		Long id = (Long)session.getAttribute("agentId");
		Agent agent=agentService.findInfo(id);
		return Result.successData(agent);
	}
	
	/**
	 * 查询提现列表
	 * @param request
	 * @return 提现列表
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<List<Cash>> list(HttpServletRequest request){
		HttpSession session = request.getSession();
		List<Cash> cash=cashService.list((Long)session.getAttribute("agentId"));
		return Result.successData(cash);
	}
}
