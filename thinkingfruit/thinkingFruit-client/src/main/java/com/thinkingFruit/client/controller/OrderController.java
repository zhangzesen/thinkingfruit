package com.thinkingFruit.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/order")
public class OrderController {

	/**
	 *仓库首页跳转
	 * */
	@RequestMapping(value="depot",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String dopet(){
		return "order/depot";
	}

}
