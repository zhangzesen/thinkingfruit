package com.thinkingFruit.admin.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkingFruit.admin.entity.Member;
import com.thinkingFruit.admin.service.MemberService;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.HttpUtils;
import com.ysdevelop.common.utils.JSONHelper;


@Controller
@RequestMapping(value="member")
public class MemberController {
	/**
	 * @author wulei
	 *
	 * @date 2018年11月19日
	 *
	 * @package com.thinkingFruit.admin.controller
	 *
	 * @description 会员页面
	 */
	@Autowired
	MemberService memberService;
	/**
	 *首页跳转
	 * */
	@RequestMapping(value="",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String index(){
		return "member/index";
	}
	/**
	 *首页列表详情
	 * */
	@RequestMapping(value="/pagination",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String pagination(HttpServletRequest request,Pagination<Member> pagination){
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		memberService.paginationCategory(pagination,queryMap);
		return JSONHelper.bean2json(Result.successPaginationData(pagination.getItems(), pagination.getTotalItemsCount()));
	}
	/**
	 *跳转会员修改页面
	 * */
	@RequestMapping(value = "/set", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String set(@RequestParam(value = "id", required = false) Long id) {
		return "member/set";
	}
	// 跳转到详细信息界面
		@RequestMapping(value = "/detail", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
		public String detail(@RequestParam(value = "id", required = false) Long id) {
			return "member/info";
		}
	
	/**
	 * 查询全部代理信息
	 * */
	@RequestMapping(value = "/selectInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String selectInfo(@RequestParam(value = "id", required = false)Long id){
		Member memberInfo = memberService.memberLevelId(id);
		System.out.println("查询结果--》"+JSONHelper.bean2json(Result.successData(memberInfo)));
		return JSONHelper.bean2json(Result.successData(memberInfo));
	}
	/**
	 * 通过代理的id修改代理信息
	 * */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
	@ResponseBody
	public Result<String> info(@Valid Member member) {
		memberService.updateById(member);
		return Result.success("修改成功");
	}	
	/**
	 * 通过代理的id删除代理
	 * */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
	@ResponseBody
	public Result<String> delete(@PathVariable Long id) {
		memberService.deleteById(id);
		return Result.success("代理注销成功");
	}
}
