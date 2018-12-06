package com.thinkingFruit.admin.entity;

import com.ysdevelop.common.entity.BaseEntity;

public class MemberBalance extends BaseEntity {
	
	private Long memberId;

	private Double balance;

	private Double pendingBalance;

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

	
}
