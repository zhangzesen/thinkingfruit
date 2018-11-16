package com.ysdevelop.common.entity;

import java.util.List;

/**
 * 
 * 
 * @author JiXiaoHui
 * 
 * @Package com.ysdevelop.oa.core.tree
 *
 * @Description: 
 * 
 * @date 2017年11月30日
 * 
 * @version
 *
 */
public class TreeNodes {
	private Integer id;//树节点ID
	private String name;//树节点名称
	private Integer parentId;//父节点ID
	private String href;//节点URL
	private Integer level;//等级
	private List<TreeNodes> children;//子节点集合
	private boolean spread = false;//节点是否展开
	private boolean checked = false;//节点是否选中
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public List<TreeNodes> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNodes> children) {
		this.children = children;
	}
	public boolean isSpread() {
		return spread;
	}
	public void setSpread(boolean spread) {
		this.spread = spread;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
}
