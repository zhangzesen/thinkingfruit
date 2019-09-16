package com.thinkingFruit.client.entity;
import com.ysdevelop.common.entity.BaseEntity;

public class ClientCommision extends BaseEntity {
	
	private Long memberId;//会员id
	
	private String orderNo;//订单号
	
	private ClientOrder order;//订单
	
	private Long inviterId;// 直推id
	
	private Double inviterMoney;//直推获得的佣金
	
	private Agent inviter;//直推会员
	
	private Long indirectId;// 间推id
	
	private Double indirectMoney;//间推获得的佣金
	
	private Agent indirect;//间推会员

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public ClientOrder getOrder() {
		return order;
	}

	public void setOrder(ClientOrder order) {
		this.order = order;
	}

	public Long getInviterId() {
		return inviterId;
	}

	public void setInviterId(Long inviterId) {
		this.inviterId = inviterId;
	}

	public Double getInviterMoney() {
		return inviterMoney;
	}

	public void setInviterMoney(Double inviterMoney) {
		this.inviterMoney = inviterMoney;
	}

	public Agent getInviter() {
		return inviter;
	}

	public void setInviter(Agent inviter) {
		this.inviter = inviter;
	}

	public Long getIndirectId() {
		return indirectId;
	}

	public void setIndirectId(Long indirectId) {
		this.indirectId = indirectId;
	}

	public Double getIndirectMoney() {
		return indirectMoney;
	}

	public void setIndirectMoney(Double indirectMoney) {
		this.indirectMoney = indirectMoney;
	}

	public Agent getIndirect() {
		return indirect;
	}

	public void setIndirect(Agent indirect) {
		this.indirect = indirect;
	}

	@Override
	public String toString() {
		return "ClientCommision [memberId=" + memberId + ", orderNo=" + orderNo + ", order=" + order + ", inviterId="
				+ inviterId + ", inviterMoney=" + inviterMoney + ", inviter=" + inviter + ", indirectId=" + indirectId
				+ ", indirectMoney=" + indirectMoney + ", indirect=" + indirect + "]";
	}
	
	
	
	
}
