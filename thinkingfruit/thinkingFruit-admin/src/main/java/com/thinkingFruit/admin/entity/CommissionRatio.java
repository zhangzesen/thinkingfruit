package com.thinkingFruit.admin.entity;

import com.ysdevelop.common.entity.BaseEntity;

/**
 * @author zhangzesen
 *
 * @date 2018年11月23日
 *
 * @package com.thinkingFruit.admin.entity
 *
 * @description 分佣/邀请比例
 */
public class CommissionRatio extends BaseEntity{
	
	/**
	 * 代理级别,1表示联创，2表示春事，3表示总监，4表示svip，5表示vip
	 */
	private Long level;
	
	/**
	 * 代理名
	 */
	private String levelName;
	
	/**
	 * 平级分佣/邀请奖比例
	 */
	private Double levelingDiscount;
	
	/**
	 * 跨级分佣/邀请奖比例
	 */
	private Double crossLevelDiscount;
	
	/**
	 * 反向级别分佣/邀请奖比例
	 */
	private Double reverseLevelDiscount;

	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public Double getLevelingDiscount() {
		return levelingDiscount;
	}

	public void setLevelingDiscount(Double levelingDiscount) {
		this.levelingDiscount = levelingDiscount;
	}

	public Double getCrossLevelDiscount() {
		return crossLevelDiscount;
	}

	public void setCrossLevelDiscount(Double crossLevelDiscount) {
		this.crossLevelDiscount = crossLevelDiscount;
	}

	public Double getReverseLevelDiscount() {
		return reverseLevelDiscount;
	}

	public void setReverseLevelDiscount(Double reverseLevelDiscount) {
		this.reverseLevelDiscount = reverseLevelDiscount;
	}
	
	
}
