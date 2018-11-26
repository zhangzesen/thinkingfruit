package com.thinkingFruit.admin.entity;

import java.util.Date;

import com.ysdevelop.common.entity.BaseEntity;

/**
 * @author zhangzesen
 *
 * @date 2018年11月21日
 *
 * @package com.thinkingFruit.admin.entity
 *
 * @description 提货订单
 */
public class Order extends BaseEntity{
	
	/**
	 * 	订单号
	 */
	private String orderNo;
	
	/**
	 * 	收件人
	 */
	private String orderMemberName;
	
	/**
	 * 	会员id
	 */
	private Long orderMemberId;
	
	/**
	 * 	手机号
	 */
	private String mobile;
	
	/**
	 * 	省
	 */
	private String province;
	
	/**
	 * 	市
	 */
	private String city;
	
	/**
	 * 	区
	 */
	private String diatrict;
	
	/**
	 * 	详细地址
	 */
	private String address;
	
	/**
	 * 	所有地址
	 */
	private String allAddress;
	
	/**
	 * 	订单备注
	 */
	private String remark;
	
	/**
	 * 	配送方式,0,邮寄,1,自取
	 */
	private Integer sendMethod;
	
	/**
	 * 	订单状态
	 */
	private String orderStatus;
	
	/**
	 * 	配送费用
	 */
	private Double freightPrice;
	
	/**
	 * 	发货时间
	 */
	private Date confirmTime;
	
	/**
	 * 	快递号
	 */
	private String expressNo;
	
	/**
	 * 	快递类型
	 */
	private String logistics;
	
	/**
	 * 	订单状态
	 */
	private String state;
	
	/**
	 *	 商品id
	 */
	private Long commodityId;
	
	/**
	 * 	商品名
	 */
	private String commodityName;
	
	/**
	 * 	商品数量
	 */
	private Long commodityCount;
	
	
	
	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public Long getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Long commodityId) {
		this.commodityId = commodityId;
	}

	public Long getCommodityCount() {
		return commodityCount;
	}

	public void setCommodityCount(Long commodityCount) {
		this.commodityCount = commodityCount;
	}

	public String getLogistics() {
		return logistics;
	}

	public void setLogistics(String logistics) {
		this.logistics = logistics;
	}

	public String getState() {
		return state;
	}

	public void setState(String orderStatus) {
		switch (orderStatus) {
		case "0":
			this.state = "待付款";
			break;
		case "1":
			this.state = "待发货";
			break;
		case "2":
			this.state = "待收货";
			break;
		case "3":
			this.state = "已完成";
			break;
		default:
			this.state = "关闭";
			break;
		}
		
	}

	public String getExpressNo() {
		return expressNo;
	}

	public void setExpressNo(String expressNo) {
		this.expressNo = expressNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderMemberName() {
		return orderMemberName;
	}

	public void setOrderMemberName(String orderMemberName) {
		this.orderMemberName = orderMemberName;
	}

	public Long getOrderMemberId() {
		return orderMemberId;
	}

	public void setOrderMemberId(Long orderMemberId) {
		this.orderMemberId = orderMemberId;
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

	public String getDiatrict() {
		return diatrict;
	}

	public void setDiatrict(String diatrict) {
		this.diatrict = diatrict;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSendMethod() {
		return sendMethod;
	}

	public void setSendMethod(Integer sendMethod) {
		this.sendMethod = sendMethod;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Double getFreightPrice() {
		return freightPrice;
	}

	public void setFreightPrice(Double freightPrice) {
		this.freightPrice = freightPrice;
	}

	public Date getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}

	public String getAllAddress() {
		return allAddress;
	}

	public void setAllAddress(String allAddress) {
		this.allAddress = allAddress;
	}
	
	
	
}
