package com.ysdevelop.shiro.service;

import java.util.Map;

import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.shiro.entity.User;

/**
 * @author JiXiaoHui
 *
 * @Description:
 *
 * @date 2018年6月12日
 */
public interface UserService {
	/** 向数据库中添加一条用户数据 **/
	void addUser(User user);

	/** 通过指定的name字段查询用户详细信息 **/
	User getUserByName(String name);

	/** 通过特定条件查询多条用户数据做分页处理,并作相关的业务处理 **/
	Pagination<User> paginationCategory(Pagination<User> pagination, Map<String, String> queryMap);

	/** 通过指定的id字段查询用户详细信息 **/
	User getUserById(Long id);

	/** 通过指定的id字段修改用户详细信息 **/
	void updateUserById(User user, Long id);

	/** 检查用户名是否已被注册 **/
	void checkName(Map<String, String> queryMap);

	/** 删除用户 **/
	void deleteUserById(Long id);

	/** 异步修改个人密码 **/
	void updateUserPassword(String oldLoginPassword, String newLoginPassword, String sureLoginPassword);

	/** 管理员修改个人密码 **/
	void updateUserPassword2(String newLoginPassword, Long id);
}
