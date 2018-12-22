package com.thinkingFruit.client.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.ysdevelop.common.entity.BaseEntity;
import com.ysdevelop.common.validator.IsChinese;
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
	/** 性别 */
	@NotNull(message = "性别不能为空")
	private Long gender;
	/** 真实姓名 */
	@NotBlank(message = "真实姓名不能为空")
	@IsChinese(message = "姓名只能为汉字")
	private String name;
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
	/** 邀请者上级id */
	private Long inviterUpperId;
	/** 省 **/
	private String province;
	/** 市 **/
	private String city;
	/** 县区 **/
	private String town;
	/** 具体地址**/
	private String address;
	@IsMobile(message = "请输入正确的手机号码")
	@NotNull(message = "手机号不能为空")
	private String mobile;
	/** 用户状态0启用，1禁用 **/
	private Long status;
	/** 身份证 **/
	@NotNull(message = "身份证号码不能为空")
	private String identityNo;
	/** 代理等级id **/
	private Long memberLevelId;
	/** 代理等级名**/
	private String memberLevelName;
	/** 个人销售额**/
	private Double salesVolume;
	/** 团队总人数（不包括自己）**/
	private Long teamNumbers;
	/**团队销售额,包括自己及所有下级的**/
	private Double teamSales;
	/** 升级状态默认0(0为未申请状态),1代表升级申请**/
	private Long upStatus;
	/**
	 * 余额
	 */
	private Double balance;
	
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Long getUpStatus() {
		return upStatus;
	}
	public void setUpStatus(Long upStatus) {
		this.upStatus = upStatus;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getTeamSales() {
		return teamSales;
	}
	public void setTeamSales(Double teamSales) {
		this.teamSales = teamSales;
	}
	public Long getTeamNumbers() {
		return teamNumbers;
	}
	public void setTeamNumbers(Long teamNumbers) {
		this.teamNumbers = teamNumbers;
	}
	public Double getSalesVolume() {
		return salesVolume;
	}
	public void setSalesVolume(Double salesVolume) {
		this.salesVolume = salesVolume;
	}
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
