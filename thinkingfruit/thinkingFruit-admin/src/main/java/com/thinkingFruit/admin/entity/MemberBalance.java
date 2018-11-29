package com.thinkingFruit.admin.entity;

import com.ysdevelop.common.entity.BaseEntity;

public class MemberBalance extends BaseEntity {
	
	private Long memberId;

	private Double balance;

	private Double pendingBalance;

	private Integer peas;

	private String cnNo;

	private Integer cnDiscount;

	private Integer cnStatus;

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getPendingBalance() {
		return pendingBalance;
	}

	public void setPendingBalance(Double pendingBalance) {
		this.pendingBalance = pendingBalance;
	}

	public Integer getPeas() {
		return peas;
	}

	public void setPeas(Integer peas) {
		this.peas = peas;
	}

	public String getCnNo() {
		return cnNo;
	}

	public void setCnNo(String cnNo) {
		this.cnNo = cnNo;
	}

	public Integer getCnDiscount() {
		return cnDiscount;
	}

	public void setCnDiscount(Integer cnDiscount) {
		this.cnDiscount = cnDiscount;
	}

	public Integer getCnStatus() {
		return cnStatus;
	}

	public void setCnStatus(Integer cnStatus) {
		this.cnStatus = cnStatus;
	}
	
}
