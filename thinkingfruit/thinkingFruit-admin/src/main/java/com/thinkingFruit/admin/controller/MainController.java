package com.thinkingFruit.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * @author wulei
 *
 * @date 2018年11月16日
 *
 * @package com.thinkingFruit.admin.controller
 *
 * @description 首页
 */
@Controller
@RequestMapping(value="/main")
public class MainController {
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String main(){
		return "user/main";
	}
}
