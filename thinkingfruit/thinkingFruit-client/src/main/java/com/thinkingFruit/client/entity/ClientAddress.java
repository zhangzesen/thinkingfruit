package com.thinkingFruit.client.entity;

import com.ysdevelop.common.entity.BaseEntity;


/**
 * @author wulei
 *
 * @date 2018年11月27日
 *
 * @package com.ysdevelop.shiro.entity
 *
 * @description 地址
 */
public class ClientAddress extends BaseEntity{

	/**会员名称*/
	private String memberName;
	/** 电话 */
	private String mobile;
	/** 省 **/
	private String province;
	/** 市 **/
	private String city;
	/** 县区 **/
	private String town;
	/** 用户状态0启用，1禁用 **/
	private Long status;
	/** 详细地址**/
	private String address;
	/** 会员id **/
	private Long memberId;
	/**提取物品数量**/
	private Long count;
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	
	
}
