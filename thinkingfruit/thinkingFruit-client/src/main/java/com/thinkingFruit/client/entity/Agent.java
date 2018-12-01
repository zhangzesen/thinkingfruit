package com.thinkingFruit.client.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

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
	@NotBlank(message = "登录名不能为空")
	private String loginName;
	/** 性别 */
	private Long gender;
	/** 真实姓名 */
	private String name;
	/** 密码 */
	@NotBlank(message = "用户名不能为空")
	@Length(min = 6, max = 16, message = "密码长度必须在6-16之间")
	private transient String pswd;
	/** 盐值 **/
	private String salt;
	/** 角色id */
	private Long avatar;
	/** 邀请者id */
	@NotNull(message = "邀请者不能为空")
	private Long inviterId;
	/** 邀请者上级id */
	//@NotNull(message = "邀请者上级不能为空")
	private Long inviterUpperId;
	/** 省 **/
//	@NotBlank(message = "省不能为空")
	private String province;
	/** 市 **/
//	@NotBlank(message = "市不能为空")
	private String city;
	/** 县区 **/
//	@NotBlank(message = "县区不能为空")
	private String town;
	@IsMobile
	private String mobile;
	/** 用户状态0启用，1禁用 **/
	private Long status;
	/** 身份证 **/
	private String identityNo;
	/** 代理等级id **/
	private Long memberLevelId;
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
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
	public Long getAvatar() {
		return avatar;
	}
	public void setAvatar(Long avatar) {
		this.avatar = avatar;
	}
	public Long getInviterId() {
		return inviterId;
	}
	public void setInviterId(Long inviterId) {
		this.inviterId = inviterId;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getInviterUpperId() {
		return inviterUpperId;
	}
	public void setInviterUpperId(Long inviterUpperId) {
		this.inviterUpperId = inviterUpperId;
	}
	
	
}
