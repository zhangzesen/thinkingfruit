package com.ysdevelop.websocket.entity;

import java.util.Date;

import com.ysdevelop.common.utils.JSONHelper;
import com.ysdevelop.websocket.define.WebsocketMessageType;

/**
 * 
 * @author oldHuang
 * 
 * @Package com.ysdevelop.websocket.entity
 * 
 * @Description 注意这里的消息实体放在redis中,没有放在数据库中,如果需要列表
 * 
 * @Date 2018年4月25日
 * 
 * @Version
 * 
 */
public class WebsocketMessage {
	private Long fromUserId;

	private Long toUserId;
	
	private WebsocketMessageType messageType;

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
	
	

	public WebsocketMessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(WebsocketMessageType messageType) {
		this.messageType = messageType;
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

	public static WebsocketMessage create(String json){
		if(json != null){
			return JSONHelper.fromJsonToObject(json, WebsocketMessage.class);	
		}else{
			return null;
		}
	}
	
    public static void main(String[] args) {
		WebsocketMessage message = new WebsocketMessage();
		message.setContent("你好");
		message.setFromUserId(1l);
		message.setToUserId(2l);
		message.setMessageType(WebsocketMessageType.ON_LINE);
		String json = JSONHelper.bean2json(message);
		System.out.println(json);
		System.out.println(WebsocketMessage.create(json).getMessageType());
    	
	}
}
