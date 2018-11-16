package com.ysdevelop.shiro.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.shiro.entity.User;

public interface UserDao {

	/** 通过特定条件查询符合条件的用户数据条数 **/
	Integer getCountByQuery(@Param("queryMap") Map<String, String> queryMap);

	/** 通过特定条件查询多条用户数据,并作分页处理 **/
	List<User> paginationUser(@Param("queryMap") Map<String, String> queryMap,
			@Param("pagination") Pagination<User> pagination);

	/** 插入一条用户数据 **/
	void addUser(@Param("user") User user);

	/** 通过指定的id字段查询用户详细信息 **/
	User getUserById(@Param("id") Long id);

	/** 通过指定的id字段修改用户详细信息 **/
	void updateUserById(@Param("user") User user, @Param("id") Long id);

	/** 通过登录名获取用户 **/
	User getUserByName(@Param("name") String name);

	/** 删除用户 **/
	void deleteUserById(@Param("id") Long id);

	/** 修改用户个人密码 **/
	void updateUserPassword(@Param("user") User user);

	/** 获取所有用户的id **/
	List<Long> findUserIdList();

	/** 获取所有用户 **/
	List<User> listUser();

	/** 根据角色id查询用户 **/
	User getUserByRoleId(@Param("roleId") Long roleId);

}
