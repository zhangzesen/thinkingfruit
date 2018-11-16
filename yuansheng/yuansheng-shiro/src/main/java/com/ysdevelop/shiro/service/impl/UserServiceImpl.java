package com.ysdevelop.shiro.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.utils.Constant;
import com.ysdevelop.shiro.core.helper.PasswordHelper;
import com.ysdevelop.shiro.entity.User;
import com.ysdevelop.shiro.mapper.UserDao;
import com.ysdevelop.shiro.realm.UserRealm;
import com.ysdevelop.shiro.service.RegionService;
import com.ysdevelop.shiro.service.UserService;
import com.ysdevelop.shiro.token.TokenManager;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	PasswordHelper passwordHelper;
	
	@Autowired
	RegionService regionService;

	@Override
	public void addUser(User user) {
		if (user == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		user.setCreateTime(new Date());
		user.setStatus(Constant.DEFALULT_ZERO);
		if(user.getRoleId() == Constant.SUPER_ADMIN){
			User dbuser = userDao.getUserByRoleId(user.getRoleId());
			if(dbuser != null){
				throw new WebServiceException(CodeMsg.ADMIN_EXIST);
			}
		}
		// 密码加密处理
		passwordHelper.encryptPassword(user);
		//查询出provinceId与cityId
		Integer agent = user.getAgent();
		if(agent != null){
			if(agent == Constant.DEFALULT_ONE){
				user.setCityId(0L);
				user.setProvinceId(regionService.findProvinceIdByProvinceName(user.getProvName()));
			}
			if(agent == 2){
				user.setProvinceId(regionService.findProvinceIdByProvinceName(user.getProvName()));
				user.setCityId(regionService.findCityIdByCityName(user.getCityName()));
			}
			if(agent == 0){
				user.setCityId(0L);
				user.setProvinceId(0L);
			}
		}
		userDao.addUser(user);
	}

	@Override
	public User getUserByName(String name) {
		if (name == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		return userDao.getUserByName(name);
	}

	@Override
	public Pagination<User> paginationCategory(Pagination<User> pagination, Map<String, String> queryMap) {
		Integer page = null;
		Integer limit = null;
		if (queryMap == null || (page = Integer.valueOf(queryMap.get("page"))) == null
				|| (limit = Integer.valueOf(queryMap.get("limit"))) == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		pagination.setPageNum(page);
		pagination.setPageSize(limit);

		Integer totalItemsCount = userDao.getCountByQuery(queryMap);
		List<User> userItems = userDao.paginationUser(queryMap, pagination);

		pagination.setItems(userItems);
		pagination.setTotalItemsCount(totalItemsCount);

		return pagination;
	}

	@Override
	public User getUserById(Long id) {
		if (id == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		return userDao.getUserById(id);
	}

	@Override
	public void updateUserById(User user, Long id) {
		if (id == null || user == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		user.setUpdateTime(new Date());
		//查询出provinceId与cityId
		if(user.getAgent() != null){
			if (user.getAgent() == Constant.DEFALULT_ONE) {
				user.setCityId(0L);
				user.setProvinceId(regionService.findProvinceIdByProvinceName(user.getProvName()));
			}
			if (user.getAgent() == 2) {
				user.setProvinceId(regionService.findProvinceIdByProvinceName(user.getProvName()));
				user.setCityId(regionService.findCityIdByCityName(user.getCityName()));
			}
			if(user.getAgent() == 0){
				user.setCityId(0L);
				user.setProvinceId(0L);
			}
		}
		userDao.updateUserById(user, id);
	}

	@Override
	public void checkName(Map<String, String> queryMap) {
		String id = queryMap.get("id");
		String loginName = queryMap.get("loginName");
		User userByName = userDao.getUserByName(loginName);
		if(id != null){
			User userById = userDao.getUserById(Long.valueOf(id));
			if(userByName != null && userByName.getId() != userById.getId()){
				throw new WebServiceException(CodeMsg.USERNAME_EXIST);
			}
		}else{
			if(userByName != null){
				throw new WebServiceException(CodeMsg.USERNAME_EXIST);
			}
		}
	}

	@Override
	public void deleteUserById(Long id) {
		if(id == null){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		userDao.deleteUserById(id);
	}

	@Override
	public void updateUserPassword(String oldLoginPassword, String newLoginPassword, String sureLoginPassword) {
		if(!newLoginPassword.equals(sureLoginPassword)){
			throw new WebServiceException(CodeMsg.PASSWORD_CONFIRM);
		}
		
		User token = TokenManager.getToken();
		User userByName = userDao.getUserByName(token.getLoginName());
		if(!passwordHelper.checkPassword(userByName, oldLoginPassword)){
			throw new WebServiceException(CodeMsg.ERROR_OLD_PASSWORD);
		}
		
		if(newLoginPassword.length() < 6){
			throw new WebServiceException(CodeMsg.PASSWORD_LENGTH_SMALL);
		}
		
		userByName.setPswd(newLoginPassword);
		passwordHelper.encryptPassword(userByName);
		userDao.updateUserPassword(userByName);
		UserRealm userRealm = UserRealm.getUserRealm();
		userRealm.clearAuthorizationInfo(userByName.getLoginName());
//		Subject subject = SecurityUtils.getSubject();
//		userRealm.clearAuthenticationInfo(subject.getSession().getId());
	}

	@Override
	public void updateUserPassword2(String newLoginPassword, Long id) {
		if(id == null){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		
		if(newLoginPassword != null && newLoginPassword.length() < 6){
			throw new WebServiceException(CodeMsg.PASSWORD_LENGTH_SMALL);
		}
		
		User user = userDao.getUserById(id);
		user.setPswd(newLoginPassword);
		passwordHelper.encryptPassword(user);
		userDao.updateUserPassword(user);
		UserRealm userRealm = UserRealm.getUserRealm();
		userRealm.clearAuthorizationInfo(user.getLoginName());
	}

}
