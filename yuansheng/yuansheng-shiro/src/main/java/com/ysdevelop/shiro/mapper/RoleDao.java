package com.ysdevelop.shiro.mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.shiro.entity.Role;

public interface RoleDao {
	/** 通过特定条件查询符合条件的角色数据条数 **/
	Integer getCountByQuery(Map<String, String> queryMap);

	/** 通过特定条件查询多条角色数据,并作分页处理 **/
	List<Role> paginationRole(@Param("queryMap") Map<String, String> queryMap,
			@Param("pagination") Pagination<Role> pagination);

	/** 通过id字段查询一条角色数据 **/
	Role getRoleById(@Param("id") Long id);

	/** 通过name字段查询一条角色数据 **/
	Role findRoleByName(@Param("name") String name);

	/** 修改一条角色数据 **/
	void updateRoleById(@Param("role") Role role, @Param("id") Long id);

	/** 根据角色ID删除角色权限关联数据 **/
	void deleteRolePermissionByRoleId(@Param("id") Long id);

	/** 批量插入角色权限关联数据 **/
	void addRolePermission(@Param("id") Long id, @Param("ids") Long[] ids);

	/** 插入一条角色数据 **/
	void addRole(Role role);

	/** 查询所有角色 **/
	List<Role> findRoleList();

	/** 通过用户名查询该用户的角色 **/
	Set<String> getRoleByUserName(@Param("name") String name);

	/** 根据字段角色ID删除角色 **/
	void deleteRoleById(@Param("id") Long id);

	/** 获取用户的角色 **/
	Set<String> listByUserId(@Param("id") Long id);

}
