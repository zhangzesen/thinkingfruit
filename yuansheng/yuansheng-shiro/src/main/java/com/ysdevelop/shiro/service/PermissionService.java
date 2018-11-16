package com.ysdevelop.shiro.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.shiro.entity.Permission;

public interface PermissionService {

	Set<String> listByUserId(Long userId);
	
	Set<String> listByUserName(String name);
	
	Integer save(Permission permission);
	/** 通过特定条件查询多条权限数据做分页处理,并作相关的业务处理 **/
	Pagination<Permission> paginationCategory(Pagination<Permission> pagination, Map<String, String> queryMap);
	/** 插入一条权限数据,并作相关的业务处理 **/
	void addPermission(Permission permission);
	/** 查询所有的权限数据制作成权限树,并作相关的业务处理 **/
	String findPermissionListToString(HttpServletRequest request);
	/** 查询所有的权限数据制作成权限树,根据角色ID所拥有的权限选中权限树中的权限,并作相关的业务处理 **/
	String findPermissionListByRoleIdToString(Long id);
	/** 查询所有的权限,并作相关的业务处理 **/
	List<Permission> findPermissionList();
	/** 根据字段id重新该权限数据,并作相关的业务处理 **/
	Permission getPermissionById(Long id);
	/** 通过权限id字段查询子权限数据做分页处理 **/
	Pagination<Permission> treePaginationCategory(Pagination<Permission> pagination, Map<String, String> queryMap);
	/** 异步修改指定ID的权限详情 **/
	void updatePermissionById(Permission permission, Long id);
	/** 删除权限 **/
	void deletePermissionById(Long id);

}
