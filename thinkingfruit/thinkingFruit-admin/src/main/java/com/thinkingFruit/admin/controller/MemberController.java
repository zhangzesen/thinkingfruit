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
	 * 跳转到审核界面
	 * @return
	 */
	@RequestMapping(value="/examine",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String examine(){
		return "member/examine";
	}
	/**
	 * 跳转到升级审核界面
	 * @return
	 */
	@RequestMapping(value="/upExamine",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String upExamine(){
		return "member/upExamine";
	}
	/**
	 * 跳转到代理邀请
	 * @return
	 */
	@RequestMapping(value="/invite",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String invite(){
		return "member/invite";
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
	 * 注册审核代理列表合计
	 * @param request
	 * @return 代理集合
	 */
	@RequestMapping(value="/examineList",method=RequestMethod.GET,produces = "application/json;charset=utf-8")
	@ResponseBody
	public Results<List<Member>> examineList(HttpServletRequest request){
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		PageInfo<Member> pageInfo= memberService.paginationExamine(queryMap);
		return Results.successPaginationData(pageInfo.getList(), pageInfo.getTotal());
	}
	/**
	 * 升级审核代理列表合计
	 * @param request
	 * @return 代理集合
	 */
	@RequestMapping(value="/upExamineList",method=RequestMethod.GET,produces = "application/json;charset=utf-8")
	@ResponseBody
	public Results<List<Member>> upExamineList(HttpServletRequest request){
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		PageInfo<Member> pageInfo= memberService.upPaginationUpExamine(queryMap);
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
	 * 跳转密码修改页面
	 * @return
	 */
	@RequestMapping(value = "/setPswd", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String setPswd() {
		return "member/setPswd";
	}
	/**
	 * 跳转代理注册审核页面
	 * @return
	 */
	@RequestMapping(value = "/examineSet", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String examineSet() {
		return "member/examineSet";
	}
	/**
	 * 跳转代理升级审核页面
	 * @return
	 */
	@RequestMapping(value = "/upExamineSet", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String upExamineSet() {
		return "member/upExamineSet";
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
	 * 通过代理的id修改代理密码
	 * @param member 代理
	 * @return
	 */
	@RequestMapping(value = "/updatePswd", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
	@ResponseBody
	public Results<String> updatePswd(@Valid Member member) {
		System.out.println("修改密码");
		memberService.updatePswd(member);
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
	/**
	 * 取消代理注册
	 * @param id 代理id
	 * @return
	 */
	@RequestMapping(value = "/cancellation", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
	@ResponseBody
	public Results<String> cancellation(Long id) {
		memberService.cancellation(id);
		return Results.success("取消代理注册成功");
	}
	
	/**
	 * 取消代理升级
	 * @param id 代理id
	 * @return
	 */
	@RequestMapping(value = "/cancelUpgrade", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
	@ResponseBody
	public Results<String> cancelUpgrade(Long id) {
		memberService.cancelUpgrade(id);
		return Results.success("取消代理升级成功");
	}
}
