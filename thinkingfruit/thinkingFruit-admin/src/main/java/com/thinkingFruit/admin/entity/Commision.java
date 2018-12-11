package com.thinkingFruit.admin.entity;
import com.ysdevelop.common.entity.BaseEntity;

public class Commision extends BaseEntity {
	
	private String orderNo;//订单号
	
	private Double totalAmount;//总金额
	
	private Double commision;// 订单佣金
	
	private Double commisionProportion;//佣金比例
	
	private Double status; //0代表佣金，1代表邀请金
	
	private Long commodityId; //商品id
	
	private Double InviteMoney;//邀请金
	
	private Long memberId;//会员id
	
	private Long inviterId;
	
	private Long inviterUpperId;
	
	private String name;//用户真实姓名
	
	private	Double inviterTotalMoney;
	
	private Double percent;//佣金占总金额的百分比
	
	private Double personTotalCommision;//个人总佣金
	
	private Double personTotalInviteMoney;//个人总邀请金
	
    private String inviterName;//上级姓名
	
	private String inviterUpperName;//上上级姓名 

	private Double personTotal;//个人总业绩
	
	public String getInviterName() {
		return inviterName;
	}

	
	
	public Double getPersonTotalInviteMoney() {
		return personTotalInviteMoney;
	}



	public void setPersonTotalInviteMoney(Double personTotalInviteMoney) {
		this.personTotalInviteMoney = personTotalInviteMoney;
	}



	public Double getPersonTotal() {
		return personTotal;
	}



	public void setPersonTotal(Double personTotal) {
		this.personTotal = personTotal;
	}



	public void setInviterName(String inviterName) {
		this.inviterName = inviterName;
	}

	public String getInviterUpperName() {
		return inviterUpperName;
	}

	public void setInviterUpperName(String inviterUpperName) {
		this.inviterUpperName = inviterUpperName;
	}

	public Double getInviterTotalMoney() {
		return inviterTotalMoney;
	}

	public void setInviterTotalMoney(Double inviterTotalMoney) {
		this.inviterTotalMoney = inviterTotalMoney;
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

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Double getPersonTotalCommision() {
		return personTotalCommision;
	}

	public void setPersonTotalCommision(Double personTotalCommision) {
		this.personTotalCommision = personTotalCommision;
	}

	
	
	public Double getCommisionProportion() {
		return commisionProportion;
	}

	public void setCommisionProportion(Double commisionProportion) {
		this.commisionProportion = commisionProportion;
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

	public Double getPercent() {
		return percent;
	}

	public void setPercent(Double percent) {
		this.percent = percent;
	}

}
