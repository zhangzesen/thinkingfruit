package com.ysdevelop.common.utils;

import java.util.ArrayList;
import java.util.List;

import com.ysdevelop.common.entity.TreeNodes;

/**
 * 
 * @author OldHuang
 * 
 * @Package com.ysdevelop.util
 * 
 * @Description: 树状数据模型构造工具类,区别了需不需要等级
 * 
 * @date 2018年3月27日
 * 
 * @version 1.0.0
 * 
 */

public class TreeGrid {
	public String treeMenu(List<TreeNodes> nodes, Integer parentId) {

		// 最后结果
		List<TreeNodes> permissionList = new ArrayList<>();
		// 先找到所有第一级权限
		for (TreeNodes treeNodes : nodes) {
			if (treeNodes.getParentId().equals(parentId)) {
				permissionList.add(treeNodes);
			}
		}

		// 为一级权限设置子权限
		for (TreeNodes treeNodes : permissionList) {
			treeNodes.setChildren(getChild(treeNodes.getId(),
					treeNodes.getLevel(), nodes));
		}
		System.out.println(JSONHelper.toJSONString(permissionList));
		return JSONHelper.toJSONString(permissionList);
	}
    /**
     * 
     * @param id 节点id
     * 
     * @param level 没有等级则为空,有等级则传入
     * 
     * @param nodes 其它节点
     * 
     * @return
     */
	private List<TreeNodes> getChild(Integer id, Integer level,
			List<TreeNodes> nodes) {
		// 子权限
		List<TreeNodes> childList = new ArrayList<>();
		for (TreeNodes treeNodes : nodes) {
			// 遍历所有节点，将父菜单id与传过来的id比较
			if (level != null) {
				if (treeNodes.getParentId().equals(id)
						&& (treeNodes.getLevel() - level == 1)) {
					childList.add(treeNodes);
				}
			} else {
				if (treeNodes.getParentId().equals(id)) {
					childList.add(treeNodes);
				}
			}
		}
		// 把子权限在循环一遍
		for (TreeNodes treeNodes : childList) {
			treeNodes.setChildren(getChild(treeNodes.getId(),
					treeNodes.getLevel(), nodes));
		}
		// 递归退出条件
		if (childList.size() == 0) {
			return null;
		}
		return childList;
	}
}
