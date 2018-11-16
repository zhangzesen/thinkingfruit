package com.ysdevelop.shiro.controller;

import java.util.List;
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

import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.HttpUtils;
import com.ysdevelop.common.utils.JSONHelper;
import com.ysdevelop.shiro.entity.Role;
import com.ysdevelop.shiro.service.PermissionService;
import com.ysdevelop.shiro.service.RoleService;

@Controller
@RequestMapping("role")
public class RoleController {

	@Autowired
	RoleService roleService;

	@Autowired
	PermissionService permissionService;

	// 跳转到角色列表界面
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index() {
		return "role/index";
	}

	// 跳转到角色添加页面
	@RequestMapping(value = "/set", method = RequestMethod.GET)
	public String set(@RequestParam(value = "id", required = false) Long id) {
		return "role/set";
	}

	// 角色列表分页
	@RequestMapping(value = "/pagination", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String pagination(HttpServletRequest request, Pagination<Role> pagination) {
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		pagination = roleService.paginationCategory(pagination, queryMap);
		return JSONHelper
				.bean2json(Result.successPaginationData(pagination.getItems(), pagination.getTotalItemsCount()));
	}

	// 生成角色授权的权限树
	@RequestMapping(value = "/permissionTree", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String permissionTree() {
		return permissionService.findPermissionListToString(null);
	}

	// 异步获取角色的详情信息
	@RequestMapping(value = "/info", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String info(@RequestParam(value = "id", required = false) Long id) {
		Role role = roleService.getRoleById(id);
		return JSONHelper.bean2json(Result.successData(role));
	}

	// 通过角色ID异步获取该角色的权限树，此角色所拥有的权限checked
	@RequestMapping(value = "/permissionTree/{id}", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String permission(@PathVariable(value = "id") Long id) {
		System.out.println("通过角色ID异步获取该角色的权限树" + permissionService.findPermissionListByRoleIdToString(id));
		return permissionService.findPermissionListByRoleIdToString(id);
	}

	// 插入一条角色数据的角色详情
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<String> addRole(@Valid Role role) {
		roleService.addRole(role);
		return Result.success("操作成功");
	}

	// 异步修改指定ID的角色详情
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<String> editRole(@Valid Role role, @PathVariable(value = "id") Long id) {
		roleService.updateRoleById(role, id);
		return Result.success("操作成功");
	}

	// 查询所有角色
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String all() {
		List<Role> roles = roleService.findRoleList();
		return JSONHelper.toJSONString(roles);
	}

	// 删除角色
	@RequestMapping(value = "", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
	@ResponseBody
	public Result<String> delete(@RequestParam(value = "id", required = false) Long id) {
		roleService.deleteRoleById(id);
		return Result.success("删除成功");
	}
}
