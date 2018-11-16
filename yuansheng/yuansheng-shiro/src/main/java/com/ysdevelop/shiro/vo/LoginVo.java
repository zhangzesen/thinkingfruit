package com.ysdevelop.shiro.vo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author oldHuang
 * 
 * @Package com.ysdevelop.shiro.vo
 * 
 * @Description 用户登录vo
 * 
 * @Date 2018年4月13日
 * 
 * @Version
 * 
 */
public class LoginVo {
	@NotBlank(message = "姓名不能为空")
	//@Size(min = 2, max = 4, message = "姓名在2到4位之间")
	private String name;
	@NotBlank(message = "密码不能为空")
	@Size(min = 6, max = 23, message = "密码长度必须在6到23之间")
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
