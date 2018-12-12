package com.thinkingFruit.admin.entity;

import com.ysdevelop.common.entity.BaseEntity;

public class PanelStatistics extends BaseEntity {

	private Long memberTotal;// 总会员数

	private Double transactionTotal;// 总交易额

	private Long orderTotal;// 订单总量

	private Long newMember;
	
	private Double commisionTotal;//总佣金

	private String province;

	private Integer count;
	
	private String day;
	
	private Long commodityTotal;
	
	private Double cashTotal;
	
	
	public Long getCommodityTotal() {
		return commodityTotal;
	}

	public void setCommodityTotal(Long commodityTotal) {
		this.commodityTotal = commodityTotal;
	}

	public Double getCashTotal() {
		return cashTotal;
	}

	public void setCashTotal(Double cashTotal) {
		this.cashTotal = cashTotal;
	}

	public Double getCommisionTotal() {
		return commisionTotal;
	}

	public void setCommisionTotal(Double commisionTotal) {
		this.commisionTotal = commisionTotal;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Long getMemberTotal() {
		return memberTotal;
	}

	public void setMemberTotal(Long memberTotal) {
		this.memberTotal = memberTotal;
	}

	public Double getTransactionTotal() {
		return transactionTotal;
	}

	public void setTransactionTotal(Double transactionTotal) {
		this.transactionTotal = transactionTotal;
	}

	public Long getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(Long orderTotal) {
		this.orderTotal = orderTotal;
	}

	public Long getNewMember() {
		return newMember;
	}

	public void setNewMember(Long newMember) {
		this.newMember = newMember;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

}
