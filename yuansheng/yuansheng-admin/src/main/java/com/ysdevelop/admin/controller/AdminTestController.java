package com.ysdevelop.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import redis.clients.jedis.JedisPool;

import com.ysdevelop.admin.redis.key.UserKey;
import com.ysdevelop.common.redis.RedisService;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.SpringContextUtils;

@Controller
@RequestMapping(value = "/adminTest")
public class AdminTestController {
	@Autowired
	private RedisService redisService;

	@RequestMapping(method=RequestMethod.GET,value="")
	@ResponseBody
	public Result<String> testResult() {
		System.out.println(redisService);
		
		//redisService.set(UserKey.userKey, "1", "老黄");
		System.out.println(redisService.get(UserKey.userKey, "1", String.class));
		System.out.println(SpringContextUtils.getBean("jedisPool", JedisPool.class));
		return Result.success("测试成功");
	}

}
