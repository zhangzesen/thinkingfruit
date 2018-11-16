package com.ysdevelop.shiro.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.ysdevelop.common.entity.BaseEntity;
import com.ysdevelop.common.validator.IsMobile;

/**
 * 
 * @author oldHuang
 * 
 * @package com.ysdevelop.shiro.entity
 * 
 * @date 2018年4月22日
 * 
 * @description 用户类
 * 
 * @version
 * 
 */
public class User extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 昵称 */
	@NotBlank(message = "昵称不能为空")
	private String nickname;
	/** 登录名 */
	@NotBlank(message = "登录名不能为空")
	private String loginName;
	/** 性别 */
	@NotNull(message = "性别不能为空")
	private Integer sex;
	/** 邮箱 */
	@Pattern(regexp = "^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]+$", message = "邮箱格式不正确,请重新填写")
	private String email;
	/** 密码 */
	@NotBlank(message = "用户名不能为空")
	@Length(min = 6, max = 16, message = "密码长度必须在6-16之间")
	private transient String pswd;
	/** 盐值 **/
	private String salt;
	/** 角色id */
	@NotNull(message = "用户角色不能为空")
	private Long roleId;
	/** 省 **/
//	@NotBlank(message = "省不能为空")
	private String provName;
	/** 市 **/
//	@NotBlank(message = "市不能为空")
	private String cityName;
	/** 县区 **/
//	@NotBlank(message = "县区不能为空")
	private String townName;
	/** 市 **/
	@IsMobile
	private String mobile;
	/** 用户状态0启用，1禁用 **/
	private Integer status;
	/** 角色名称 **/
	private String roleName;
	/** 最后退出时间 **/
	private Date loginOutTime;
	/** 用户角色集合 **/
	private Set<String> roleSet;
	/** 用户权限集合 **/
	private Set<String> permissionSet;
	
	/** 性别字符串格式 **/
	private String sexStr;
	
	/** 管理等级**/
//	@NotNull(message = "管理等级不能为空")
	private Integer agent;
	
	private Long provinceId;
	
	private Long cityId;
	
	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Integer getAgent() {
		return agent;
	}

	public void setAgent(Integer agent) {
		this.agent = agent;
	}

	public String getSexStr() {
		return sexStr;
	}

	public void setSexStr(String sexStr) {
		this.sexStr = sexStr;
	}

	public Set<String> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<String> roles) {
		this.roleSet = roles;
	}

	public Set<String> getPermissionSet() {
		return permissionSet;
	}

	public void setPermissionSet(Set<String> permissionSet) {
		this.permissionSet = permissionSet;
	}

	public Date getLoginOutTime() {
		return loginOutTime;
	}

	public void setLoginOutTime(Date loginOutTime) {
		this.loginOutTime = loginOutTime;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getProvName() {
		return provName;
	}

	public void setProvName(String provName) {
		this.provName = provName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getTownName() {
		return townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
