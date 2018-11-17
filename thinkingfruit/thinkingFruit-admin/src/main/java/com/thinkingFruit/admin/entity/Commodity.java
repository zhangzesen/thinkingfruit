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
	 *  商品图片id
	 */
	private String previewImageid;
	
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
	 * 商品规格
	 */
	@NotEmpty(message="请输入商品的规格")
	private String commoditySpecation;
	
	/**
	 * 商品批准文号
	 */
	private String approvalNumber;
	
	/**
	 * 商品规格Id
	 */
	private Long specationId;
	
	/**
	 * 开始时间
	 */
	private String createTime;
	
	/**
	 * 结束时间
	 */
	private String updateTime;
	
	/**
	 * 商品顺序
	 */
	private Integer index;
}
