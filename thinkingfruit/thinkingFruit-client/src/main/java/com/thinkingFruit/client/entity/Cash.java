package com.thinkingFruit.client.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

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
	@NotNull(message = "提现金额不能为空")
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
	@NotBlank(message = "开户银行不能为空")
	private String openBank;
	
	/**
	 * 银行卡号
	 */
	@NotNull(message = "银行卡号不能为空")
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
