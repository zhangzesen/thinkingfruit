package com.thinkingFruit.admin.entity;

import com.ysdevelop.common.entity.BaseEntity;


public class Depot extends BaseEntity{

	/**
	 * 数量
	 * */
	private Long count;
	/**
	 * 会员Id
	 * */
	private Long memberId;
	/**
	 *商品id
	 * */
	private Long commodityId;
	/**
	 *商品名称
	 * */
	private String name;
	/**
	 *商品图片
	 * */
	private String coverImagePath;
	/**
	 *会员名称
	 * */
	private String memberName;
	
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCoverImagePath() {
		return coverImagePath;
	}
	public void setCoverImagePath(String coverImagePath) {
		this.coverImagePath = coverImagePath;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public Long getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(Long commodityId) {
		this.commodityId = commodityId;
	}
	
	
}
