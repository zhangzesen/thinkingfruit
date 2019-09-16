package com.thinkingFruit.client.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ysdevelop.common.entity.BaseEntity;
import com.ysdevelop.common.validator.IsMobile;


/**
 * @author zhangzesen
 *
 * @date 2018年11月27日
 *
 * @package com.ysdevelop.shiro.entity
 *
 * @description 代理
 */
public class Agent extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** 登录名 */
	private String loginName;
	
	/** 密码 */
	@Length(min = 6, max = 16, message = "密码长度必须在6-16之间")
	private transient String pswd;
	
	/** 盐值 **/
	private String salt;
	
	/** 角色头像 */
	@NotNull(message = "用户头像不能为空")
	private String avatar;
	
	/** 邀请者id */
	private Long inviterId;
	
	@IsMobile(message = "请输入正确的手机号码")
	@NotNull(message = "手机号不能为空")
	private String mobile;
	
	/** 代理等级id **/
	private Long memberLevelId;
	
	/** 代理等级名**/
	private String memberLevelName;
	
	/** 团队总人数（不包括自己）**/
	private Long teamNumbers;
	
	/**
	 * 余额
	 */
	private Double balance;

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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getMemberLevelId() {
		return memberLevelId;
	}

	public void setMemberLevelId(Long memberLevelId) {
		this.memberLevelId = memberLevelId;
	}

	public String getMemberLevelName() {
		return memberLevelName;
	}

	public void setMemberLevelName(String memberLevelName) {
		this.memberLevelName = memberLevelName;
	}

	public Long getTeamNumbers() {
		return teamNumbers;
	}

	public void setTeamNumbers(Long teamNumbers) {
		this.teamNumbers = teamNumbers;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
