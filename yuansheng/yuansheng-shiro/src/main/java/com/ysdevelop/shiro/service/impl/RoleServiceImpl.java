package com.ysdevelop.shiro.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.shiro.entity.Role;
import com.ysdevelop.shiro.entity.User;
import com.ysdevelop.shiro.mapper.RoleDao;
import com.ysdevelop.shiro.mapper.UserDao;
import com.ysdevelop.shiro.realm.UserRealm;
import com.ysdevelop.shiro.service.RoleService;

/**
 * 
 * @author JiXiaoHui
 *
 * @Description:
 *
 * @date 2018年6月9日
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleDao;

	@Autowired
	UserDao userDao;

	@Override
	public Set<String> getRoleByUserName(String name) {
		if (name == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		return roleDao.getRoleByUserName(name);
	}

	@Override
	public Pagination<Role> paginationCategory(Pagination<Role> pagination, Map<String, String> queryMap) {
		Integer page = null;
		Integer limit = null;
		if (queryMap == null || (page = Integer.valueOf(queryMap.get("page"))) == null
				|| (limit = Integer.valueOf(queryMap.get("limit"))) == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		pagination.setPageNum(page);
		pagination.setPageSize(limit);

		Integer totalItemsCount = roleDao.getCountByQuery(queryMap);
		List<Role> roleItems = roleDao.paginationRole(queryMap, pagination);

		pagination.setItems(roleItems);
		pagination.setTotalItemsCount(totalItemsCount);

		return pagination;
	}

	@Override
	public Role getRoleById(Long id) {
		if (id == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		return roleDao.getRoleById(id);
	}

	@Override
	@Transactional
	public void updateRoleById(Role role, Long id) {
		if (id == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		Role roleByName = roleDao.findRoleByName(role.getName());
		if (roleByName == null || roleByName.getId().equals(id)) {
			role.setUpdateTime(new Date());
			roleDao.updateRoleById(role, id);
			if (role.getIds() != null && role.getIds().length > 0) {
				// 添加角色所拥有的权限之前，将数据库中的原有权限删除
				roleDao.deleteRolePermissionByRoleId(id);
				roleDao.addRolePermission(id, role.getIds());
				List<User> userList = userDao.listUser();
				for (User user : userList) {
					if (id == user.getRoleId()) {
						UserRealm userRealm = UserRealm.getUserRealm();
						userRealm.clearAuthorizationInfo(user.getLoginName());
					}
				}
			}
		}
	}

	@Override
	@Transactional
	public void addRole(Role role) {
		if (role == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		role.setCreateTime(new Date());
		roleDao.addRole(role);
		roleDao.addRolePermission(role.getId(), role.getIds());
	}

	@Override
	public List<Role> findRoleList() {
		return roleDao.findRoleList();
	}

	@Transactional
	@Override
	public void deleteRoleById(Long id) {
		if (id == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		roleDao.deleteRoleById(id);
		List<User> userList = userDao.listUser();
		for (User user : userList) {
			if (id == user.getRoleId()) {
				UserRealm userRealm = UserRealm.getUserRealm();
				userRealm.clearAuthorizationInfo(user.getLoginName());
			}
		}
		// 删除该角色所拥有的权限
		roleDao.deleteRolePermissionByRoleId(id);
	}

	@Override
	public Set<String> listByUserId(Long userId) {
		return roleDao.listByUserId(userId);
	}

}
