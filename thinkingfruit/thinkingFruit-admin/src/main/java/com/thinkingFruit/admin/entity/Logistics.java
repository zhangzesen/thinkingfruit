package com.thinkingFruit.admin.entity;

/**
 * @author zhangzesen
 *
 * @date 2018年11月20日
 *
 * @package com.thinkingFruit.admin.entity
 *
 * @description 物流
 */
public class Logistics {
	
	/**
	 * id
	 */
	private Long id;
	
	/**
	 * 	物流编码
	 */
	private String logisticsNo;
	
	/**
	 * 	快递公司
	 */
	private String express;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogisticsNo() {
		return logisticsNo;
	}

	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
	}

	public String getExpress() {
		return express;
	}

	public void setExpress(String express) {
		this.express = express;
	}
	
	
}
