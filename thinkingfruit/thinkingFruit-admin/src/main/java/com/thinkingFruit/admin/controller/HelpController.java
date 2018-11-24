package com.thinkingFruit.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wulei
 *
 * @date 2018年11月23日
 *
 * @package com.thinkingFruit.admin.controller
 *
 * @description 帮助中心
 */

@Controller
@RequestMapping(value="help")
public class HelpController {
	/**
	 *页面跳转帮助index
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String help(){
		return "user/help";
	}
}
