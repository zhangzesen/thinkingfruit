package com.thinkingFruit.client.entity;
import com.ysdevelop.common.entity.BaseEntity;

public class ClientCommision extends BaseEntity {
	
	private String orderNo;//订单号
	
	private Double totalAmount;//总金额
	
	private Double commision;// 订单佣金
	
	private Double commisionProportion;//佣金比例
	
	private Double status; //0代表佣金，1代表邀请金
	
	private Long commodityId; //商品id
	
	private Double InviteMoney;//邀请金
	
	private Long memberId;//会员id
	
	private Long inviterId;
	
	private String name;//用户真实姓名

	private Long inviterUpperId;
	
	
	private Double inviterTotalMoney;//上级获得的总金额
	
	private Double totalCommision;//个人总佣金
	
	private Double totalInviteMoney;//个人总邀请金
	
	
	
	public Double getTotalCommision() {
		return totalCommision;
	}

	public void setTotalCommision(Double totalCommision) {
		this.totalCommision = totalCommision;
	}

	public Double getTotalInviteMoney() {
		return totalInviteMoney;
	}

	public void setTotalInviteMoney(Double totalInviteMoney) {
		this.totalInviteMoney = totalInviteMoney;
	}

	public Double getInviterTotalMoney() {
		return inviterTotalMoney;
	}

	public void setInviterTotalMoney(Double inviterTotalMoney) {
		this.inviterTotalMoney = inviterTotalMoney;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Double getCommisionProportion() {
		return commisionProportion;
	}

	public void setCommisionProportion(Double commisionProportion) {
		this.commisionProportion = commisionProportion;
	}

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
	
	public Long getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Long commodityId) {
		this.commodityId = commodityId;
	}

	public Double getInviteMoney() {
		return InviteMoney;
	}

	public void setInviteMoney(Double inviteMoney) {
		InviteMoney = inviteMoney;
	}
	
	
	public Long getInviterId() {
		return inviterId;
	}

	public void setInviterId(Long inviterId) {
		this.inviterId = inviterId;
	}

	public Long getInviterUpperId() {
		return inviterUpperId;
	}

	public void setInviterUpperId(Long inviterUpperId) {
		this.inviterUpperId = inviterUpperId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ClientCommision [orderNo=" + orderNo + ", totalAmount=" + totalAmount + ", commision=" + commision
				+ ", commisionProportion=" + commisionProportion + ", status=" + status + ", commodityId=" + commodityId
				+ ", InviteMoney=" + InviteMoney + ", memberId=" + memberId + ", inviterId=" + inviterId + ", name="
				+ name + ", inviterUpperId=" + inviterUpperId + ", inviterTotalMoney=" + inviterTotalMoney
				+ ", totalCommision=" + totalCommision + ", totalInviteMoney=" + totalInviteMoney + "]";
	}


}
