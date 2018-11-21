package com.thinkingFruit.admin.entity;
import com.ysdevelop.common.entity.BaseEntity;

public class Commision extends BaseEntity {
	
	private String orderNo;//订单号
	
	private Double totalAmount;//总金额
	
	private Double commision;// 订单总佣金/订单的个人佣金
	
	private Double percent;//佣金占总金额的百分比
	
	private String nicknames;//收益人昵称集合
	
	private byte[] nickname;//受益人昵称
	
	private String nicknameStr;
	
	private Double personTotalCommision;//个人总佣金
	
	private Long memberId;//会员id
	
	private String name;//用户真实姓名

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

	public String getNicknameStr() {
		return nicknameStr;
	}

	public void setNicknameStr(String nicknameStr) {
		this.nicknameStr = nicknameStr;
	}
	
	public void setNicknameStr(){
		this.nicknameStr = new String(nickname);
	}

	public byte[] getNickname() {
		return nickname;
	}

	public void setNickname(byte[] nickname) {
		this.nickname = nickname;
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

	public String getNicknames() {
		return nicknames;
	}

	public void setNicknames(String nicknames) {
		this.nicknames = nicknames;
	}

}
