package com.ysdevelop.shiro.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.shiro.entity.Role;

public interface RoleService {
	Set<String> getRoleByUserName(String name);
	/** 通过特定条件查询多条角色数据做分页处理,并作相关的业务处理 **/
	Pagination<Role> paginationCategory(Pagination<Role> pagination, Map<String, String> queryMap);
	/** 通过id字段查询一条角色数据,并作相关的业务处理 **/
	Role getRoleById(Long id);
	/** 修改一条角色数据,并作相关的业务处理 **/
	void updateRoleById(Role role, Long id);
	/** 插入一条角色数据,并作相关的业务处理 **/
	void addRole(Role role);
	/** 查询所有角色 **/
	List<Role> findRoleList();
	/** 根据字段角色ID删除角色 **/
	void deleteRoleById(Long id);
	/** 获取用户的角色 
	 * @param userId **/
	Set<String> listByUserId(Long userId);
}
