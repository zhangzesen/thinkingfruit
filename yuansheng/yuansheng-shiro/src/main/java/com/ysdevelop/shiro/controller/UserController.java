package com.ysdevelop.shiro.controller;

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

import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.HttpUtils;
import com.ysdevelop.common.utils.JSONHelper;
import com.ysdevelop.shiro.core.RedisSessionDao;
import com.ysdevelop.shiro.entity.User;
import com.ysdevelop.shiro.service.UserService;
import com.ysdevelop.shiro.token.TokenManager;
import com.ysdevelop.shiro.vo.LoginVo;

/**
 * 
 * @author oldHuang
 * 
 * @package com.ysdevelop.shiro.controller
 * 
 * @date 2018年4月18日
 * 
 * @description 用户
 * 
 * @version
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	RedisSessionDao redisSessionDao;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}

	/** 用户登录 **/
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Result<String> doLogin(HttpServletRequest request, LoginVo loginVo) {
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		String randCode = queryMap.get("randCode");
		String randCodeValidate = (String) request.getSession().getAttribute("randCode");
		if (randCodeValidate == null || !randCodeValidate.equalsIgnoreCase(randCode)) {
			throw new WebServiceException(CodeMsg.CODE_VALIDATE);
		}
		TokenManager.login(loginVo);
		return Result.success("登录成功");
	}

	/** 用户列表分页 **/
	@RequestMapping(value = "/pagination", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String pagination(HttpServletRequest request, Pagination<User> pagination) {
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		pagination = userService.paginationCategory(pagination, queryMap);
		return JSONHelper
				.bean2json(Result.successPaginationData(pagination.getItems(), pagination.getTotalItemsCount()));
	}

	/** 跳转到用户添加页面 **/
	//@RequiresPermissions("user:set")
	@RequestMapping(value = "/set", method = RequestMethod.GET)
	public String set(@RequestParam(value = "id", required = false) Long id) {
		return "user/set";
	}

	/** 添加用户 **/
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public Result<String> addUser(@Valid User user) {
		userService.addUser(user);
		return Result.success("操作成功");
	}

	/** 异步获取用戶的详情信息 **/
	@RequestMapping(value = "/info", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String info(@RequestParam(value = "id", required = false) Long id) {
		User user = null;
		if(id != null){
			user = userService.getUserById(id);
		}else{
			user = userService.getUserByName(TokenManager.getToken().getLoginName());
		}
		return JSONHelper.bean2json(Result.successData(user));
	}

	/** 异步修改指定ID的角色详情 **/
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<String> editUser(@Valid User user, @PathVariable(value = "id") Long id) {
		userService.updateUserById(user, id);
		return Result.success("操作成功");
	}

	/** 跳转用户列表界面 **/
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index() {
		return "user/index";
	}

	/** 退出登录 **/
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		TokenManager.logout();
		return "user/login";
	}
	
	/** 检查用户名是否已被注册 **/
	@RequestMapping(value = "/checkName", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public void checkName(HttpServletRequest request) {
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		userService.checkName(queryMap);
	}
	
	/** 删除用户 **/
	@RequestMapping(value = "", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
	@ResponseBody
	public Result<String> delete(@RequestParam(value = "id", required = false) Long id) {
		userService.deleteUserById(id);
		return Result.success("删除成功");
	}
	
	/** 通过登录名获取用户ID **/
	@RequestMapping(value = "/information", method = RequestMethod.GET)
	public String information() {
		return "user/information";
	}
	
	/** 跳转到密码修改页面 **/
	@RequestMapping(value = "/password", method = RequestMethod.GET)
	public String password(@RequestParam(value = "id", required = false) Long id) {
		return "user/password";
	}
	
	/** 异步修改个人密码 **/
	@RequestMapping(value = "/editPassword", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<String> editPassword(
			@RequestParam(value = "oldLoginPassword", required = false) String oldLoginPassword,
			@RequestParam(value = "newLoginPassword", required = false) String newLoginPassword,
			@RequestParam(value = "sureLoginPassword", required = false) String sureLoginPassword) {
		userService.updateUserPassword(oldLoginPassword,newLoginPassword,sureLoginPassword);
		return Result.success("密码修改成功");
	}
	
	/** 管理员修改个人密码 **/
	@RequestMapping(value = "/editPassword/{id}", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<String> editPasswordByid(@PathVariable(value = "id") Long id,
			@RequestParam(value = "newLoginPassword", required = false) String newLoginPassword){
		userService.updateUserPassword2(newLoginPassword,id);
		return Result.success("密码修改成功");
	}
}
