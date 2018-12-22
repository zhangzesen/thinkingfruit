package com.thinkingFruit.client.entity;

import java.util.List;

/**
 * @author zhangzesen
 *
 * @date 2018年11月17日
 *
 * @package com.thinkingFruit.client.entity
 *
 * @description 商品实体类
 */
public class ClientCommodity {
	
	/**
	 * 	商品id
	 */
	private Long id;
	
	/**
	 *	 商品名
	 */
	private String name;
	
	
	/**
	 * 	商品展示图
	 */
	private String coverImagePath;
	
	/**
	 * 	商品详情图集合
	 */
	private List<String> detailsImagePaths;// 商品详情图
	
	/**
	 *	 商品详情图
	 */
	private String detailsImagePath;
	
	
	/**
	 *	 商品描述
	 */
	private String description;
	
	/**
	 * 	商品销量
	 */
	private Long sales;
	
	/**
	 * 	商品联创价
	 */
	private Double firstPrice;
	
	/**
	 * 	商品春事价
	 */
	private Double secondPrice;
	
	/**
	 * 	商品总监价
	 */
	private Double thirdPrice;
	
	/**
	 * 	商品svip价
	 */
	private Double fourthPrice;
	
	/**
	 * 	商品vip价
	 */
	private Double fifthPrice;
	
	/**
	 *	 商品库存
	 */
	private Long stock;
	
	/**
	 * 	商品批准文号
	 */
	private String approvalNumber;
	
	/**
	 * 	开始时间
	 */
	private String createTime;
	
	/**
	 * 	结束时间
	 */
	private String updateTime;
	
	/**
	 *	 商品状态，0代表激活，1代表注销
	 */
	private Integer status;
	
	/**
	 * 	当前价格
	 */
	private Double price;

	public Long getId() {
		return id;
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoverImagePath() {
		return coverImagePath;
	}

	public void setCoverImagePath(String coverImagePath) {
		this.coverImagePath = coverImagePath;
	}

	public List<String> getDetailsImagePaths() {
		return detailsImagePaths;
	}

	public void setDetailsImagePaths(List<String> detailsImagePaths) {
		this.detailsImagePaths = detailsImagePaths;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getSales() {
		return sales;
	}

	public void setSales(Long sales) {
		this.sales = sales;
	}

	public Double getFirstPrice() {
		return firstPrice;
	}

	public void setFirstPrice(Double firstPrice) {
		this.firstPrice = firstPrice;
	}

	public Double getSecondPrice() {
		return secondPrice;
	}

	public void setSecondPrice(Double secondPrice) {
		this.secondPrice = secondPrice;
	}

	public Double getThirdPrice() {
		return thirdPrice;
	}

	public void setThirdPrice(Double thirdPrice) {
		this.thirdPrice = thirdPrice;
	}

	public Double getFourthPrice() {
		return fourthPrice;
	}

	public void setFourthPrice(Double fourthPrice) {
		this.fourthPrice = fourthPrice;
	}

	public Double getFifthPrice() {
		return fifthPrice;
	}

	public void setFifthPrice(Double fifthPrice) {
		this.fifthPrice = fifthPrice;
	}
	
	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public String getApprovalNumber() {
		return approvalNumber;
	}

	public void setApprovalNumber(String approvalNumber) {
		this.approvalNumber = approvalNumber;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getDetailsImagePath() {
		return detailsImagePath;
	}

	public void setDetailsImagePath(String detailsImagePath) {
		this.detailsImagePath = detailsImagePath;
	}
}
