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
	 * 邀请金
	 */
	private Double inviteMoney;
	
	/**
	 * 邀请者获得的分佣
	 */
	private Double inviterTotalMoney;
	
	/**
	 *	 邀请者上级
	 */
	private Long inviterUpperId;
	
	
	/**
	 * 	邀请者上级分佣比例
	 */
	private Double commisionProportion;
	
	/**
	 * 邀请者上级分得的佣金
	 */
	private Double commision;
	
	/**
	 * 订单完成时间
	 */
	private Date confirmTime;
	
	/**
	 * 订单总价
	 */
	private Double orderTotalPrice;
	
	/**
	 * 订单审核状态，0表示未审核，1表示已审核
	 */
	private Long checkStatus;
	
	/**
	 * 凭证图片
	 */
	private String certificateImage;
	
	
	
	public String getCertificateImage() {
		return certificateImage;
	}

	public void setCertificateImage(String certificateImage) {
		this.certificateImage = certificateImage;
	}

	public Long getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(Long checkStatus) {
		this.checkStatus = checkStatus;
	}

	public Double getInviteMoney() {
		return inviteMoney;
	}

	public void setInviteMoney(Double inviteMoney) {
		this.inviteMoney = inviteMoney;
	}

	public Double getInviterTotalMoney() {
		return inviterTotalMoney;
	}

	public void setInviterTotalMoney(Double inviterTotalMoney) {
		this.inviterTotalMoney = inviterTotalMoney;
	}

	public Double getCommision() {
		return commision;
	}

	public void setCommision(Double commision) {
		this.commision = commision;
	}

	public Double getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(Double orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	public Date getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
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

	public String getMemberLevelName() {
		return memberLevelName;
	}

	public void setMemberLevelName(String memberLevelName) {
		this.memberLevelName = memberLevelName;
	}

	public Long getInviterUpperId() {
		return inviterUpperId;
	}

	public void setInviterUpperId(Long inviterUpperId) {
		this.inviterUpperId = inviterUpperId;
	}

	public Double getCommisionProportion() {
		return commisionProportion;
	}

	public void setCommisionProportion(Double commisionProportion) {
		this.commisionProportion = commisionProportion;
	}
	
	
}
