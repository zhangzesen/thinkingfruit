package com.thinkingFruit.client.entity;
import com.ysdevelop.common.entity.BaseEntity;

public class ClientCommision extends BaseEntity {
	
	private String orderNo;//订单号
	
	private Double totalAmount;//总金额
	
	private Double commision;// 订单佣金
	
	private Double status; //0代表佣金，1代表邀请金
	
	private Double orderAmout;//订单总金额  
	
	private Double commodityId; //商品id
	
	private Double InviteMoney;//邀请金
	
	private Long memberId;//会员id
	
	private String name;//用户真实姓名

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getCommision() {
		return commision;
	}

	public void setCommision(Double commision) {
		this.commision = commision;
	}

	public Double getStatus() {
		return status;
	}

	public void setStatus(Double status) {
		this.status = status;
	}

	public Double getOrderAmout() {
		return orderAmout;
	}

	public void setOrderAmout(Double orderAmout) {
		this.orderAmout = orderAmout;
	}

	public Double getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Double commodityId) {
		this.commodityId = commodityId;
	}

	public Double getInviteMoney() {
		return InviteMoney;
	}

	public void setInviteMoney(Double inviteMoney) {
		InviteMoney = inviteMoney;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
