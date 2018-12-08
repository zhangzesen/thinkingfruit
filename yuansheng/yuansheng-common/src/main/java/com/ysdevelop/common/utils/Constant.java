package com.ysdevelop.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 常量
 * 
 * @author laohuang
 * @email
 * @date
 */
public class Constant {
	/**
	 * 超级管理员ID
	 */
	public static final int SUPER_ADMIN = 1;

	/**
	 * 判断是否为0
	 */
	public static final Integer DEFALULT_ZERO = 0;

	/**
	 * 判断是否为1
	 */
	public static final Integer DEFALULT_ONE = 1;
	
	/**
	 * 判断是否2
	 */
	public static final Integer DEFALULT_TWO = 2;

	/**
	 * ORACLE、MYSQL
	 */
	public static final String USE_DATA = "MYSQL";

	/**
	 * WEBSOCKET
	 * 
	 */
	public static final String WEB_SOCKET = "websocket";

	/**
	 * RESPONSE_GOOD_STATUS
	 */
	public static final Integer RESPONSE_GOOD = 200;

	/**
	 * REDIS_SHIRO_ALL
	 */
	public static final String REDIS_SHIRO_ALL = "*ysdevelop-shiro-session:*";
	
	/**
	 * REDIS_SHIRO_AUTH
	 */
	public static final String REDIS_SHIRO_AUTH = "com.ysdevelop.shiro.realm.UserRealm.authenticationCache";
	
	public static final int DEFALULT_ZERO_INT = 0;
	
	public static final int DEFALULT_ONE_INT = 1;
	
	public static final int DEFALULT_TWO_INT = 2;
	
	public static final int DEFALULT_THREE_INT = 3;
	
	/**
	 * 是否类型
	 */
	public enum YESNO {
		/**
		 * 是
		 */
		YES(0),
		/**
		 * 否
		 */
		NO(1);
		private Integer value;

		private YESNO(Integer value) {
			this.value = value;
		}

		public Integer getValue() {
			return value;
		}
	}

	public enum MemberStatus {
		UNACTIVATED(0, "未激活"), ACTIVATED(1, "激活"), GUEST(2, "豆客"), AGENT(3, "代理");
		private int index;
		private String value;

		private MemberStatus(Integer index, String value) {
			this.index = index;
			this.value = value;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

	// 上传文件的类型
	public enum FileType {
		IMAGE(0, "图片"), VIDEO(1, "视频");
		private int index;
		private String chineseName;

		private FileType(int index, String chineseName) {
			this.index = index;
			this.chineseName = chineseName;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public String getChineseName() {
			return chineseName;
		}

		public void setChineseName(String chineseName) {
			this.chineseName = chineseName;
		}

	}

	// 上传文件的类型
	public enum HttpMethod {
		GET(0, "GET"), POST(1, "POST");
		private int index;
		private String value;

		private HttpMethod(int index, String value) {
			this.index = index;
			this.value = value;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

	// 消息枚举类
	public enum MessageType {

	}

	// 预约订单类型
	public enum OrderDepositType {
		UNPAYMENYT(0, "待付款"), UNDELIVERY(1, "待派单"), UNWAITINGORDER(2, "待接单"), WAITINGORDER(3, "已接单"), FINISHED(4, "已完成"), CLOSED(5, "关闭");
		private int index;
		private String value;

		private OrderDepositType(int index, String value) {
			this.index = index;
			this.value = value;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

	// 订单类型
	public enum OrderType {
		UNPAYMENYT(0, "未付款"), UNSEND(1, "待发货"), UNRECEIVED(2, "待收货"), FINISHED(3, "已完成"), CLOSED(4, "关闭");
		private int index;
		private String value;

		private OrderType(int index, String value) {
			this.index = index;
			this.value = value;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}
	
	//省份json
	public static final String province = "['北京','天津','河北','山西','内蒙古','辽宁','吉林','黑龙江','上海','江苏','浙江','安徽','福建','江西','山东','河南','湖北','湖南','广东','广西','海南','重庆','四川','贵州','云南','西藏','陕西','甘肃','青海','宁夏','新疆','港澳']";


	// 选择图片上传的路径
	public static final Map<Integer, String> IMAGE_PATH = new HashMap<Integer, String>();
	public static final Map<Integer, String> VIDEO_PATH = new HashMap<Integer, String>();

	public static final String IMAGE_BRAND = "/upload/images/brand/";
	public static final String IMAGE_COMMODITYCATEGORY = "/upload/images/commodityCategory/";
	public static final String IMAGE_COMMODITY = "/upload/images/commodity/";
	public static final String IMAGE_SCROLL = "/upload/images/scroll/";
	public static final String IMAGE_WECHAT_NEWS = "/upload/images/wechatnews/";
	public static final String IMAGE_WECHAT_COVER = "/upload/images/wechatcover/";
	public static final String IMAGE_NEWS = "/upload/images/news/";
	public static final String IMAGE_SHOP = "/upload/images/shop/";
	public static final String IMAGE_ARTICLE = "/upload/images/article/";
	public static final String IMAGE_MINISTRY = "/upload/images/ministry/";
	
	//源盛官网图片路径
	public static final String IMAGE_PRODUCT = "/upload/images/product/";
	public static final String IMAGE_THEME = "/upload/images/theme/";
	public static final String IMAGE_TEAM = "/upload/images/team/";
	public static final String IMAGE_CATEGORY = "/upload/images/category/";
	public static final String IMAGE_OUTLINE = "/upload/images/outline/";

	public static final String VIDEO_COMMODITY = "/upload/video/commodity/";
	public static final String VIDEO_MINISTRY = "/upload/video/ministry/";

	static {
		IMAGE_PATH.put(0, IMAGE_BRAND);
		IMAGE_PATH.put(1, IMAGE_COMMODITYCATEGORY);
		IMAGE_PATH.put(2, IMAGE_COMMODITY);
		IMAGE_PATH.put(3, IMAGE_SCROLL);
		IMAGE_PATH.put(4, IMAGE_WECHAT_NEWS);
		IMAGE_PATH.put(5, IMAGE_WECHAT_COVER);
		IMAGE_PATH.put(6, IMAGE_NEWS);
		IMAGE_PATH.put(7, IMAGE_SHOP);
		IMAGE_PATH.put(8, IMAGE_ARTICLE);
		IMAGE_PATH.put(9, IMAGE_MINISTRY);
		IMAGE_PATH.put(10, IMAGE_PRODUCT);
		IMAGE_PATH.put(11, IMAGE_THEME);
		IMAGE_PATH.put(12, IMAGE_TEAM);
		IMAGE_PATH.put(13, IMAGE_CATEGORY);
		IMAGE_PATH.put(14, IMAGE_OUTLINE);

		VIDEO_PATH.put(0, VIDEO_COMMODITY);
		VIDEO_PATH.put(1, VIDEO_MINISTRY);
	}

}
