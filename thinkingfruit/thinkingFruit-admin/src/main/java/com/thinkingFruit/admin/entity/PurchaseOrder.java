package com.thinkingFruit.admin.entity;

import com.ysdevelop.common.entity.BaseEntity;

/**
 * @author zhangzesen
 *
 * @date 2018年11月21日
 *
 * @package com.thinkingFruit.admin.entity
 *
 * @description 交易订单
 */
public class PurchaseOrder extends BaseEntity{
	
	
	/**
	 * 	订单号
	 */
	private String orderNo;
	
	/**
	 * 	收件人
	 */
	private String orderMemberName;
	
	/**
	 * 	代理等级，1代表联创，2表示春事，3表示总监，4表示SVIP，5表示VIP
	 */
	private Long memberLevel;
	
	/**
	 * 代理等级名
	 */
	private String memberLevelName;
	
	/**
	 * 	代理id
	 */
	private Long orderMemberId;
	
	/**
	 * 	订单状态
	 */
	private String orderStatus;
	
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
	
	/**
	 * 	商品价格
	 */
	private Double commodityPrice;
	
	/**
	 * 	上级id
	 */
	private Long superiorMemberId;
	
	/**
	 *	 是否首单，0表示首单，1表示不是，0有邀请者分佣和邀请费，1只有分佣
	 */
	private String isFirst;
	
	/**
	 * 	邀请者id
	 */
	private Long inviterId;
	
	/**
	 * 	邀请者分佣比例
	 */
	private Double inviterProportion;
	
	/**
	 * 	上级分佣比例
	 */
	private Double superiorProportion;

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

	public Long getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(Long memberLevel) {
		this.memberLevel = memberLevel;
	}

	public Long getOrderMemberId() {
		return orderMemberId;
	}

	public void setOrderMemberId(Long orderMemberId) {
		this.orderMemberId = orderMemberId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Long getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Long commodityId) {
		this.commodityId = commodityId;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public Long getCommodityCount() {
		return commodityCount;
	}

	public void setCommodityCount(Long commodityCount) {
		this.commodityCount = commodityCount;
	}

	public Double getCommodityPrice() {
		return commodityPrice;
	}

	public void setCommodityPrice(Double commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	public Long getSuperiorMemberId() {
		return superiorMemberId;
	}

	public void setSuperiorMemberId(Long superiorMemberId) {
		this.superiorMemberId = superiorMemberId;
	}

	public String getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(String isFirst) {
		this.isFirst = isFirst;
	}

	public Long getInviterId() {
		return inviterId;
	}

	public void setInviterId(Long inviterId) {
		this.inviterId = inviterId;
	}

	public Double getInviterProportion() {
		return inviterProportion;
	}

	public void setInviterProportion(Double inviterProportion) {
		this.inviterProportion = inviterProportion;
	}

	public Double getSuperiorProportion() {
		return superiorProportion;
	}

	public void setSuperiorProportion(Double superiorProportion) {
		this.superiorProportion = superiorProportion;
	}

	public String getMemberLevelName() {
		return memberLevelName;
	}

	public void setMemberLevelName(String memberLevelName) {
		this.memberLevelName = memberLevelName;
	}
	
	
}
