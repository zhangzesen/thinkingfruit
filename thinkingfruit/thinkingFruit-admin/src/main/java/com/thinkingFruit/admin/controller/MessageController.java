package com.thinkingFruit.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkingFruit.admin.entity.Message;
import com.thinkingFruit.admin.key.MessageKey;
import com.thinkingFruit.admin.service.MessageService;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.redis.RedisService;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.HttpUtils;
import com.ysdevelop.common.utils.JSONHelper;

@Controller
@RequestMapping(value="/message")
public class MessageController {
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	private RedisService redisService;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String index(){
		return "message/index";
	}
	
	@RequestMapping(value = "/pagination", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String pagination(HttpServletRequest request,Pagination<Message> pagination){
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		messageService.paginationMessage(pagination,queryMap);
		return JSONHelper.bean2json(Result.successPaginationData(pagination.getItems(), pagination.getTotalItemsCount()));
	}
	
	// 消息的删除
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
	@ResponseBody
	public Result<String> del(@RequestParam(value = "id", required = false) Long id) {
		messageService.deleteMessageById(id);
		return Result.success("删除成功");
	}
	
	// 批量删除项目
	@RequestMapping(value = "batch", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<String> deleteBatch(@RequestParam(value = "messageIds[]", required = false) List<Long> messageIds) {
		messageService.deleteBatch(messageIds);
		return Result.success("删除成功");
	}
	
	//redis轮询
	@RequestMapping(value = "/redisPolling", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String redisPolling(){
		boolean isExists = redisService.exists(MessageKey.messageKey, "Message");
		redisService.delete(MessageKey.messageKey, "Message");
		return JSONHelper.bean2json(Result.successData(isExists));
	}
}
