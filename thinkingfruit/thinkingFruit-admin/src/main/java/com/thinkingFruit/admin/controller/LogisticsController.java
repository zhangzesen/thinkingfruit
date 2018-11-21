package com.thinkingFruit.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkingFruit.admin.entity.Logistics;
import com.thinkingFruit.admin.service.LogisticsService;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.JSONHelper;

/**
 * @author zhangzesen
 *
 * @date 2018年11月20日
 *
 * @package com.thinkingFruit.admin.controller
 *
 * @description 物流
 */
@Controller
@RequestMapping(value="logistics")
public class LogisticsController {

	@Autowired
	LogisticsService logisticsService;
	
	/**
	 * 	获取物流
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String get(){
		List<Logistics> logistics = logisticsService.get();
		return JSONHelper.bean2json(Result.successData(logistics));
	}
		
}
