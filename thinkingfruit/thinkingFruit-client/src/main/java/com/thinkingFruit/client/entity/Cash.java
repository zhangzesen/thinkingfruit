package com.thinkingFruit.client.entity;

import com.ysdevelop.common.entity.BaseEntity;

/**
 * @author zhangzesen
 *
 * @date 2018年12月5日
 *
 * @package com.thinkingFruit.client.entity
 *
 * @description 提现
 */
public class Cash extends BaseEntity {
	/**
	 * 代理id
	 */
	private Long memberId;
	
	/**
	 * 提现金额
	 */
	private Double cash;
	
	/**
	 * 提现状态
	 */
	private Long status;
	
	/**
	 * 备注
	 */
	private String account;
	
	/**
	 * 开户银行
	 */
	private String openBank;
	
	/**
	 * 银行卡号
	 */
	private String bankNumber;

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Double getCash() {
		return cash;
	}

	public void setCash(Double cash) {
		this.cash = cash;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getOpenBank() {
		return openBank;
	}

	public void setOpenBank(String openBank) {
		this.openBank = openBank;
	}

	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}
	
	
}
