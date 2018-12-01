package com.thinkingFruit.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.thinkingFruit.admin.entity.Member;
import com.thinkingFruit.admin.service.MemberService;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.result.Results;
import com.ysdevelop.common.utils.HttpUtils;


/**
 * @author	zhangzesen
 *
 * @package	com.thinkingFruit.admin.controller
 *
 * @date	2018年11月30日
 *
 * @description	代理
 * 
 */
@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	/**
	 *	首页跳转
	 */
	@RequestMapping(value="",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String index(){
		return "member/index";
	}
	
	/**
	 * 首页代理列表
	 * @param request
	 * @return 代理集合
	 */
	@RequestMapping(value="/pagination",method=RequestMethod.GET,produces = "application/json;charset=utf-8")
	@ResponseBody
	public Results<List<Member>> pagination(HttpServletRequest request){
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		PageInfo<Member> pageInfo= memberService.paginationMember(queryMap);
		return Results.successPaginationData(pageInfo.getList(), pageInfo.getTotal());
	}
	
	/**
	 * 跳转代理修改页面
	 * @return
	 */
	@RequestMapping(value = "/set", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String set() {
		return "member/set";
	}
	
	/**
	 * 代理详情界面
	 * @return
	 */
	@RequestMapping(value = "/info", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String detail() {
		return "member/info";
	}
	
	/**
	 * 查询代理详情
	 * @param id 代理id
	 * @return
	 */
	@RequestMapping(value = "/details", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody
	public Results<Member> details(@RequestParam(value = "id", required = false)Long id){
		Member member = memberService.memberById(id);
		return Results.successData(member);
	}
	
	/**
	 * 通过代理的id修改代理信息
	 * @param member 代理
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
	@ResponseBody
	public Results<String> update(@Valid Member member) {
		memberService.updateById(member);
		return Results.success("修改成功");
	}
	
	/**
	 * 通过代理id删除代理
	 * @param id 代理id
	 * @return
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
	@ResponseBody
	public Result<String> delete(Long id) {
		System.out.println("id"+id);
		memberService.deleteById(id);
		return Result.success("代理注销成功");
	}
}
