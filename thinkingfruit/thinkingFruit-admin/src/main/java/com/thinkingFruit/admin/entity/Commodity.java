package com.thinkingFruit.admin.entity;

import org.hibernate.validator.constraints.NotEmpty;

import com.ysdevelop.common.validator.IsPrice;

/**
 * @author zhangzesen
 *
 * @date 2018年11月17日
 *
 * @package com.thinkingFruit.admin.entity
 *
 * @description 商品实体类
 */
public class Commodity {
	
	/**
	 * 商品id
	 */
	private Long id;
	
	/**
	 * 商品名
	 */
	@NotEmpty(message="商品名不能为空")
	private String name;
	
	
	/**
	 * 商品展示图
	 */
	@NotEmpty(message="请选择商品展示图片")
	private String coverImagePath;
	
	/**
	 * 商品轮播图id
	 */
	private Long previewImageId;
	
	/**
	 * 商品轮播图
	 */
	private String[] previewImagePath;
	
	/**
	 * 商品详情图id
	 */
	private Long detailsImageId;
	
	/**
	 * 商品详情图
	 */
	private String[] detailsImagePath;// 商品详情图
	
	/**
	 * 商品描述
	 */
	@NotEmpty(message="请输入商品卖点")
	private String description;
	
	/**
	 * 商品销量
	 */
	private Integer sales;
	
	/**
	 * 商品联创价
	 */
	@IsPrice
	private Double firstPrice;
	
	/**
	 * 商品春事价
	 */
	@IsPrice
	private Double secondPrice;
	
	/**
	 * 商品总监价
	 */
	@IsPrice
	private Double thirdPrice;
	
	/**
	 * 商品svip价
	 */
	@IsPrice
	private Double fourthPrice;
	
	/**
	 * 商品vip价
	 */
	@IsPrice
	private Double fifthPrice;
	
	/**
	 * 商品库存
	 */
	private Integer stock;
	
	/**
	 * 商品批准文号
	 */
	private String approvalNumber;
	
	/**
	 * 开始时间
	 */
	private String createTime;
	
	/**
	 * 结束时间
	 */
	private String updateTime;
	
	/**
	 * 商品状态，0代表激活，1代表注销
	 */
	private Integer status;

	public Long getId() {
		return id;
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

	public Long getPreviewImageId() {
		return previewImageId;
	}

	public void setPreviewImageId(Long previewImageId) {
		this.previewImageId = previewImageId;
	}

	public String[] getPreviewImagePath() {
		return previewImagePath;
	}

	public void setPreviewImagePath(String[] previewImagePath) {
		this.previewImagePath = previewImagePath;
	}

	public Long getDetailsImageId() {
		return detailsImageId;
	}

	public void setDetailsImageId(Long detailsImageId) {
		this.detailsImageId = detailsImageId;
	}

	public String[] getDetailsImagePath() {
		return detailsImagePath;
	}

	public void setDetailsImagePath(String[] detailsImagePath) {
		this.detailsImagePath = detailsImagePath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
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

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
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
	
	
}
