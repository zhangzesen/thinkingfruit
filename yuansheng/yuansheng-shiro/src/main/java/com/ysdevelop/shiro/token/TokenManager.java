package com.ysdevelop.shiro.token;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;

import com.ysdevelop.common.utils.SpringContextUtils;
import com.ysdevelop.shiro.core.session.CustomSessionManager;
import com.ysdevelop.shiro.entity.User;
import com.ysdevelop.shiro.realm.UserRealm;
import com.ysdevelop.shiro.vo.LoginVo;

public class TokenManager {

	// 用户登录管理
	public static final UserRealm userRealm = SpringContextUtils.getBean("userRealm", UserRealm.class);

	//用户session管理
	public static final CustomSessionManager customSessionManager = SpringContextUtils.getBean("customSessionManager",CustomSessionManager.class);
		
	
	/**
	 * 获取当前登录的用户User对象
	 * 
	 * @return
	 */
	public static User getToken() {
		User token = (User) SecurityUtils.getSubject().getPrincipal();
		return token;
	}

	/**
	 * 获取当前用户的Session
	 * 
	 * @return
	 */
	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}

	/**
	 * 把值放入到当前登录用户的Session里
	 * 
	 * @param key
	 * @param value
	 */
	public static void setVal2Session(Object key, Object value) {
		getSession().setAttribute(key, value);
	}

	/**
	 * 从当前登录用户的Session里取值
	 * 
	 * @param key
	 * @return
	 */
	public static Object getVal2Session(Object key) {
		return getSession().getAttribute(key);
	}

	/**
	 * 登录
	 * 
	 * @param user
	 * @param rememberMe
	 * @return
	 */
	public static User login(LoginVo loginVo) {
		UsernamePasswordToken token = new UsernamePasswordToken(loginVo.getName(), loginVo.getPassword());
		SecurityUtils.getSubject().login(token);
		return getToken();
	}

	/**
	 * 退出登录
	 */
	public static void logout() {
		User token = TokenManager.getToken();
		UserRealm.getUserRealm().clearAuthorizationInfo(token.getLoginName());
		SecurityUtils.getSubject().logout();
	}
	
	/**
	 * 获取当前用户ID
	 * @return
	 */
	public static Long getUserId(){
		return getToken()==null?null:getToken().getId();
	}
	
	/**
	 * 根据UserIds 	清空权限信息。
	 * @param id	用户ID
	 */
	public static void clearUserAuthByUserName(User...users){
		if(null == users || users.length == 0)	return ;
		for (User user : users) {
			userRealm.clearAuthorizationInfo(user.getLoginName());
		}
	}


	/**
	 * 方法重载
	 * @param userIds
	 */
//	public static void clearUserAuthByUserId(List<Long> userIds) {
//		if(null == userIds || userIds.size() == 0){
//			return ;
//		}
//		clearUserAuthByUserId(userIds.toArray(new Long[0]));
//	}

}
