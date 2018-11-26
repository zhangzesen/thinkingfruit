package com.thinkingFruit.admin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkingFruit.admin.key.StatisticsKey;
import com.thinkingFruit.admin.service.OrderService;
import com.thinkingFruit.admin.service.PanelStatisticsService;
import com.ysdevelop.common.redis.RedisService;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.JSONHelper;


/**
 * @author wulei
 *
 * @date 2018年11月26日
 *
 * @package com.thinkingFruit.admin.controller
 *
 * @description 统计
 */
@Controller
@RequestMapping(value = "statistics")
public class PanelStatisticsController {
	//统计
	@Autowired
	PanelStatisticsService panelStatisticsService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	RedisService redisService;
	/**
	 * 跳转到统计index界面
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String index() {
		return "panelStatistics/index";
	}
	/**
	 *返回redis键值对对象
	 * @return
	 */
	@RequestMapping(value = "/redisCache", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String statisticsRedis() {
		System.out.println("StatisticsKey.statisticsKey-->"+StatisticsKey.statisticsKey);
		System.out.println("Map.class-->"+Map.class);
		return JSONHelper.bean2json(Result.successData(
				redisService.get(StatisticsKey.statisticsKey, "statistics", Map.class)));
	}
	
}
