package com.thinkingFruit.client.entity;

import java.util.List;

import com.ysdevelop.common.entity.BaseEntity;

/**
 * @author zhangzesen
 *
 * @date 2018年11月17日
 *
 * @package com.thinkingFruit.client.entity
 *
 * @description 商品实体类
 */
public class ClientCommodity extends BaseEntity {
	
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
	 * 	商品批准文号
	 */
	private String approvalNumber;
	
	/**
	 *	0-在售，1-下架
	 */
	private Integer status;
	
	/**
	 * 	当前价格
	 */
	private Double price;

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

	public String getDetailsImagePath() {
		return detailsImagePath;
	}

	public void setDetailsImagePath(String detailsImagePath) {
		this.detailsImagePath = detailsImagePath;
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

	public String getApprovalNumber() {
		return approvalNumber;
	}

	public void setApprovalNumber(String approvalNumber) {
		this.approvalNumber = approvalNumber;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	
	
}
