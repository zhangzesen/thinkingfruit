package com.ysdevelop.shiro.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.common.entity.TreeNodes;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.utils.Constant;
import com.ysdevelop.common.utils.HttpUtils;
import com.ysdevelop.common.utils.TreeGrid;
import com.ysdevelop.shiro.entity.Permission;
import com.ysdevelop.shiro.mapper.PermissionDao;
import com.ysdevelop.shiro.service.PermissionService;

/**
 * 
 * @author oldHuang
 * 
 * @Package com.ysdevelop.shiro.service.impl
 * 
 * @Description 权限Service
 * 
 * @Date 2018年4月23日
 * 
 * @Version
 * 
 */
@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	PermissionDao permissionDao;

	@Override
	public Set<String> listByUserId(Long userId) {
		return permissionDao.listByUserId(userId);
	}

	@Override
	public Integer save(Permission permission) {

		return null;
	}

	@Override
	public Set<String> listByUserName(String name) {
		// Set<String> permissions = new HashSet<String>();
		// permissions.add("system:menu");
		// permissions.add("board:list");
		// permissions.add("user:list");
		if (name == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		return permissionDao.listByUserName(name);
	}

	@Override
	/** 通过特定条件查询多条权限数据做分页处理 */
	public Pagination<Permission> paginationCategory(Pagination<Permission> pagination, Map<String, String> queryMap) {
		Integer page = null;
		Integer limit = null;
		if (queryMap == null || (page = Integer.valueOf(queryMap.get("page"))) == null
				|| (limit = Integer.valueOf(queryMap.get("limit"))) == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		pagination.setPageNum(page);
		pagination.setPageSize(limit);

		Integer totalItemsCount = permissionDao.getCountByQuery(queryMap);
		List<Permission> permissionItems = permissionDao.paginationPermission(queryMap, pagination);

		pagination.setItems(permissionItems);
		pagination.setTotalItemsCount(totalItemsCount);

		return pagination;
	}

	@Override
	/** 插入一条权限数据 */
	public void addPermission(Permission permission) {
		if (permission == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		Permission pinByUrl = permissionDao.findPermissionByUrl(permission.getUrl());
		// 判断数据库中是否已存在该权限URL
		if (pinByUrl != null) {
			throw new WebServiceException(CodeMsg.PERMISSION_URL_EXIST);
		}
		permissionDao.addPermission(permission);
	}

	@Override
	/** 查询所有的权限数据制作成权限树 **/
	public String findPermissionListToString(HttpServletRequest request) {
		TreeGrid treeGrid = new TreeGrid();
		List<TreeNodes> permissionList = permissionDao.findPermissionListToString();
		// 判断传过来的request对象是否为空来设置树节点的href值（为空则是角色授权权限树，不为空则是左侧导航栏权限树）
		if (request == null) {
			for (TreeNodes treeNodes : permissionList) {
				treeNodes.setHref(null);
			}
		} else {
			String basePath = HttpUtils.getContextHttpUri(request);
			for (TreeNodes treeNodes : permissionList) {
				treeNodes.setHref(basePath + treeNodes.getHref() + "/infoson?id=" + treeNodes.getId());
			}
		}
		// Constant.DEFALULT_ZERO参数0表示获取整个权限树
		String treeMenu = treeGrid.treeMenu(permissionList, Constant.DEFALULT_ZERO);
		return treeMenu;
	}

	@Override
	/** 通过角色ID异步获取权限树，此角色所拥有的权限checked **/
	public String findPermissionListByRoleIdToString(Long id) {
		if (id == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		TreeGrid treeGrid = new TreeGrid();
		// 所有权限数据
		List<TreeNodes> permissionList = permissionDao.findPermissionListToString();
		for (TreeNodes treeNodes : permissionList) {
			treeNodes.setHref(null);
		}

		// 通过角色ID查找角色所拥有的权限 并赋予TreeNodes的checked属性true
		List<Permission> permissionsByRoleId = permissionDao.findPermissionListByRoleId(id);
		for (int i = 0; i < permissionList.size(); i++) {
			for (int j = 0; j < permissionsByRoleId.size(); j++) {
				if (permissionList.get(i).getId().longValue() == permissionsByRoleId.get(j).getId().longValue()) {
					System.out.println(permissionList.get(i));
					permissionList.get(i).setChecked(true);
				}
			}
		}

		String treeMenu = treeGrid.treeMenu(permissionList, Constant.DEFALULT_ZERO);
		return treeMenu;
	}

	@Override
	/** 查询所有的权限 **/
	public List<Permission> findPermissionList() {
		return permissionDao.findPermissionList();
	}

	@Override
	/** 根据字段id重新该权限数据 **/
	public Permission getPermissionById(Long id) {
		if (id == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		return permissionDao.getPermissionById(id);
	}

	/** 通过权限id字段查询子权限数据做分页处理 **/
	@Override
	public Pagination<Permission> treePaginationCategory(Pagination<Permission> pagination,
			Map<String, String> queryMap) {
		Long id = Long.valueOf(queryMap.get("id"));
		Integer page = null;
		Integer limit = null;
		if (queryMap == null || (page = Integer.valueOf(queryMap.get("page"))) == null
				|| (limit = Integer.valueOf(queryMap.get("limit"))) == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		pagination.setPageNum(page);
		pagination.setPageSize(limit);

		Integer totalItemsCount = permissionDao.getTreeCountByQuery(queryMap, id);
		List<Permission> permissionItems = permissionDao.treePaginationPermission(queryMap, pagination, id);

		pagination.setItems(permissionItems);
		pagination.setTotalItemsCount(totalItemsCount);

		return pagination;
	}

	/** 异步修改指定ID的权限详情 **/
	@Override
	public void updatePermissionById(Permission permission, Long id) {
		if(id == null){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		permission.setUpdateTime(new Date());
		permissionDao.updatePermissionById(permission,id);
	}

	@Override
	public void deletePermissionById(Long id) {
		if(id == null){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		permissionDao.deletePermissionById(id);
	}
}
