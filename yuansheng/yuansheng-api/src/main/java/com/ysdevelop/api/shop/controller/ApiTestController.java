package com.ysdevelop.api.shop.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysdevelop.common.entity.User;

@Controller
@RequestMapping("/api/test")
public class ApiTestController {
    
	@RequestMapping(value="/userInfo",method=RequestMethod.GET,produces="text/json;charset=UTF-8")
	@ResponseBody
	public String userInfo(@Valid User user){
		return "老黄：我是小三";
	}
	
}
