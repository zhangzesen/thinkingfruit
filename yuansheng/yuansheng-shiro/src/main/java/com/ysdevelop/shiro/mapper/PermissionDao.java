package com.ysdevelop.shiro.mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.ysdevelop.common.entity.TreeNodes;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.shiro.entity.Permission;

public interface PermissionDao {
	/** 通过特定条件查询权限数据的总条数 **/
	Integer getCountByQuery(@Param("queryMap") Map<String, String> queryMap);

	/** 通过特定条件查询多条权限数据做分页处理 **/
	List<Permission> paginationPermission(@Param("queryMap") Map<String, String> queryMap,
			@Param("pagination") Pagination<Permission> pagination);

	/** 插入一条权限数据 **/
	void addPermission(@Param("permission") Permission permission);

	/** 通过字段url查询权限数据 **/
	Permission findPermissionByUrl(@Param("url") String url);

	/** 查询所有的权限数据,包装为节点对象集合 **/
	List<TreeNodes> findPermissionListToString();

	/** 通过字段id查询该角色下的所有权限数据 **/
	List<Permission> findPermissionListByRoleId(@Param("id") Long id);

	/** 查询所有权限 **/
	List<Permission> findPermissionList();

	/** 根据字段id重新该权限数据 **/
	Permission getPermissionById(@Param("id") Long id);

	/** 根据用户登录名获取权限的url **/
	Set<String> listByUserName(@Param("name") String name);

	/** 通过权限id字段查询子权限数据总数 **/
	Integer getTreeCountByQuery(@Param("queryMap") Map<String, String> queryMap, @Param("id") Long id);

	/** 通过权限id字段查询子权限数据做分页处理 **/
	List<Permission> treePaginationPermission(@Param("pagination") Map<String, String> queryMap,
			@Param("pagination") Pagination<Permission> pagination, @Param("id") Long id);

	/** 异步修改指定ID的权限详情 **/
	void updatePermissionById(@Param("permission") Permission permission, @Param("id") Long id);

	/** 删除权限 **/
	void deletePermissionById(@Param("id") Long id);

	/** 获取某个用户的权限 **/
	Set<String> listByUserId(@Param("id") Long id);

}
