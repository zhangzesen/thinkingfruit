package com.thinkingFruit.admin.entity;

import javax.validation.constraints.NotNull;

public class Member{
	//id
	private Long id;
	//邀请人id
	private Long inviterId;
	// 会员昵称
	private byte[] nickname;// 昵称,二进制保存emoji表情
	private String nicknameStr;// 昵称显示
	//会员姓名
	private String name;
	// 性别0代理女，1代理男
	private Integer gender;
	// 手机号
	private String mobile;
	// 头像
	private String avatar;
	// 市
	private String city;
	// 省
	private String country;
	// 国家
	private String province;
	// 状态0代表审核未通过，1代表审核通过
	private Integer status;
	// 用户所用户的级别0联创，1春事，2总监，3svip，4vip
	private Long memberId;
	// 用户的上级id
	@NotNull(message = "上级ID不能为空")
	private Long parentMemberId;
	// 用户的上级名
	private byte[] parentMemberName;
	private String parentMemberNameStr;
	//身份证号
	private String identityNo;
	//用户余额
	private String balance;
	//交易量
	private String transaction;
	//用户等级id
	private String memberLevelId;
	//用户级别
	private String level;
	

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getMemberLevelId() {
		return memberLevelId;
	}

	public void setMemberLevelId(String memberLevelId) {
		this.memberLevelId = memberLevelId;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
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

	public byte[] getParentMemberName() {
		return parentMemberName;
	}

	public void setParentMemberName(byte[] parentMemberName) {
		this.parentMemberName = parentMemberName;
	}

	public String getParentMemberNameStr() {
		return parentMemberNameStr;
	}

	public void setParentMemberNameStr(String parentMemberNameStr) {
		this.parentMemberNameStr = parentMemberNameStr;
	}
	
	public void setParentMemberNameStr(){
		this.parentMemberNameStr = new String(parentMemberName);
	}


	public Long getParentMemberId() {
		return parentMemberId;
	}

	public void setParentMemberId(Long parentMemberId) {
		this.parentMemberId = parentMemberId;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}



	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getInviterId() {
		return inviterId;
	}

	public void setInviterId(Long inviterId) {
		this.inviterId = inviterId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	
}
