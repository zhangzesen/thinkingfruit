package com.thinkingFruit.admin.entity;

import com.ysdevelop.common.entity.BaseEntity;

public class Cash extends BaseEntity {
	
	private Long memberId;//用户id
	
	/**
	 * 登录名
	 */
	private String loginName;
	
	private Integer cash;//提现现金
	
	private Integer status;//提现状态
	
	private String account;// 备注
	
	private String bankNumber;//银行卡号
	
	private String openBank;//开户银行

	private String name;
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOpenBank() {
		return openBank;
	}

	public void setOpenBank(String openBank) {
		this.openBank = openBank;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}


	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Integer getCash() {
		return cash;
	}

	
	
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public void setCash(Integer cash) {
		this.cash = cash;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}
}
