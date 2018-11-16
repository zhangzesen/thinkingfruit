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
import com.ysdevelop.shiro.entity.Permission;
import com.ysdevelop.shiro.service.PermissionService;

@Controller
@RequestMapping("permission")
public class PermissionController {

	@Autowired
	PermissionService permissionService;

	/** 跳转到权限列表界面 **/
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index() {
		return "permission/index";
	}

	/** 生成权限树 **/
	@RequestMapping(value = "/permissionTree", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String permissionTree(HttpServletRequest request) {
		return permissionService.findPermissionListToString(request);
	}

	/** 权限列表分页显示 **/
	@RequestMapping(value = "/pagination", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String pagination(HttpServletRequest request, Pagination<Permission> pagination) {
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		pagination = permissionService.paginationCategory(pagination, queryMap);
		return JSONHelper
				.bean2json(Result.successPaginationData(pagination.getItems(), pagination.getTotalItemsCount()));
	}

	/** 根据权限Id字段权限树列表分页显示 **/
	@RequestMapping(value = "/pagination/{id}", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String treePagination(@PathVariable(value = "id") Long id, HttpServletRequest request,
			Pagination<Permission> pagination) {
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		queryMap.put("id", id.toString());
		pagination = permissionService.treePaginationCategory(pagination, queryMap);
		return JSONHelper
				.bean2json(Result.successPaginationData(pagination.getItems(), pagination.getTotalItemsCount()));
	}

	/** 查询所有权限 **/
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String all(HttpServletRequest request) {
		List<Permission> permissions = permissionService.findPermissionList();
		return JSONHelper.toJSONString(permissions);
	}

	/** 跳转到权限添加界面 **/
	@RequestMapping(value = "/set", method = RequestMethod.GET)
	public String set(@RequestParam(value = "id", required = false) Long id) {
		return "permission/set";
	}

	/** 显示修改界面权限的详细信息 **/
	@RequestMapping(value = "/info", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String info(@RequestParam(value = "id", required = false) Long id) {
		Permission permission = permissionService.getPermissionById(id);
		return JSONHelper.bean2json(Result.successData(permission));
	}

	/** 添加权限 **/
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public Result<String> addPermission(@Valid Permission permission) {
		permissionService.addPermission(permission);
		return Result.success("操作成功");
	}

	/** 异步修改指定ID的权限详情 **/
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<String> editRole(@Valid Permission permission, @PathVariable(value = "id") Long id) {
		permissionService.updatePermissionById(permission, id);
		return Result.success("操作成功");
	}

	/** 显示指定权限ID的权限及其子权限 **/
	@RequestMapping(value = "/infoson", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	public String permissionInfo(@RequestParam(value = "id", required = false) Long id) {
		return "permission/info";
	}

	/** 删除权限 **/
	@RequestMapping(value = "", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
	@ResponseBody
	public Result<String> delete(@RequestParam(value = "id", required = false) Long id) {
		permissionService.deletePermissionById(id);
		return Result.success("删除成功");
	}
}
