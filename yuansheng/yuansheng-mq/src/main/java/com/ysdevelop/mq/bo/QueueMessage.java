package com.ysdevelop.mq.bo;

import java.util.Date;

/**
 * 
 * @author oldHuang
 * 
 * @Package com.ysdevelop.mq.bo
 * 
 * @Description 该消息实体是client与admin端共用的
 * 
 * @Date 2018年4月25日
 * 
 * @Version
 * 
 */
public class QueueMessage {

	private Long fromUserId;

	private Long toUserId;

	private String content;

	private Date createTime;    


	public Long getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(Long fromUserId) {
		this.fromUserId = fromUserId;
	}

	public Long getToUserId() {
		return toUserId;
	}

	public void setToUserId(Long toUserId) {
		this.toUserId = toUserId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
