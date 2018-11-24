package com.thinkingFruit.admin.entity;

import com.ysdevelop.common.entity.BaseEntity;

/**
 * @author zhangzesen
 *
 * @date 2018年11月24日
 *
 * @package com.thinkingFruit.admin.entity
 *
 * @description 消息
 */
public class Message extends BaseEntity {
	/**
	 * 消息内容
	 */
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
