package com.thinkingFruit.admin.entity;

import com.ysdevelop.common.entity.BaseEntity;


/**
 * @author	zhangzesen
 *
 * @package	com.thinkingFruit.admin.entity
 *
 * @date	2018年11月30日
 *
 * @description	代理
 * 
 */
public class Member extends BaseEntity{
	/**
	 * 登录名
	 */
	private String loginName;
	/**
	 * 密码
	 */
	private String pswd;
	/***
	 * 手机号
	 */
	private String mobile;
	/**
	 * 性别0代理女，1代理男
	 */
	private Long gender;
	/**
	 * 代理真实姓名
	 */
	private String name;
	/**
	 * 头像
	 */
	private String avatar;
	/**
	 * 邀请人id
	 */
	private Long inviterId;
	/***
	 * 邀请者的上级id
	 */
	private Long inviterUpperId;
	/**
	 * 状态0代表审核未通过，1代表审核通过
	 */
	private Long status;
	/**
	 * 身份证号
	 */
	private String identityNo;
	/**
	 * 用户所用户的级别1联创，2春事，3总监，4svip，5vip
	 */
	private Long memberLevelId;
	/**
	 * 用户余额
	 */
	private String balance;
	/**
	 * 交易量
	 */
	private String transaction;
	/**
	 * 代理级别名
	 */
	private Long upStatus;
	
	public Long getUpStatus() {
		return upStatus;
	}
	public void setUpStatus(Long upStatus) {
		this.upStatus = upStatus;
	}
	private String memberLevelName;
	
	public String getMemberLevelName() {
		return memberLevelName;
	}
	public void setMemberLevelName(String memberLevelName) {
		this.memberLevelName = memberLevelName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Long getGender() {
		return gender;
	}
	public void setGender(Long gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Long getInviterId() {
		return inviterId;
	}
	public void setInviterId(Long inviterId) {
		this.inviterId = inviterId;
	}
	public Long getInviterUpperId() {
		return inviterUpperId;
	}
	public void setInviterUpperId(Long inviterUpperId) {
		this.inviterUpperId = inviterUpperId;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public String getIdentityNo() {
		return identityNo;
	}
	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}
	public Long getMemberLevelId() {
		return memberLevelId;
	}
	public void setMemberLevelId(Long memberLevelId) {
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
	
	
}
