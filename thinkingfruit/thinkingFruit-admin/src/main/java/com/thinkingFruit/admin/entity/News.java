package com.thinkingFruit.admin.entity;

import org.hibernate.validator.constraints.NotEmpty;

import com.ysdevelop.common.entity.BaseEntity;

public class News extends BaseEntity {
	// 资讯名称
	@NotEmpty(message="资讯名不能为空")
	private String name;

	// 资讯标题
	@NotEmpty(message="资讯标题不能为空")
	private String title;

	// 资讯描述
	@NotEmpty(message="资讯描述不能为空")
	private String description;

	// 咨询内容
	@NotEmpty(message="资讯内容不能为空")
	private String content;
	
	//封面图片
	@NotEmpty(message="请选择封面图片")
	private String coverImagePath;

	public String getCoverImagePath() {
		return coverImagePath;
	}

	public void setCoverImagePath(String coverImagePath) {
		this.coverImagePath = coverImagePath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
