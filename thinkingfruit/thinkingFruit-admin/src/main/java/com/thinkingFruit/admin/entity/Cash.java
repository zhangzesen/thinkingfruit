package com.thinkingFruit.admin.entity;

import com.ysdevelop.common.entity.BaseEntity;

public class Cash extends BaseEntity {
	
	private Long memberId;//用户id
	
	// 会员名称
	private byte[] nickname;// 昵称,二进制保存emoji表情
	private String nicknameStr;// 昵称显示
	
	private Integer cash;//提现现金
	
	private Integer status;//提现状态
	
	private String account;// 真实姓名
	
	private String bankNumber;//银行卡号
	
	private String openBank;//开户银行

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

	public byte[] getNickname() {
		return nickname;
	}

	public void setNickname(byte[] nickname) {
		this.nickname = nickname;
	}

	public String getNicknameStr() {
		return nicknameStr;
	}

	public void setNicknameStr(String nicknameStr) {
		this.nicknameStr = nicknameStr;
	}
	
	public void setNicknameStr(){
		this.nicknameStr = new String(nickname);
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
