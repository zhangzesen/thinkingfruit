package com.ysdevelop.websocket.define;

/**
 * 
 * @author oldHuang
 * 
 * @Package com.ysdevelop.websocket.define
 * 
 * @Description Websocket 消息类型枚举
 * 
 * @Date 2018年5月3日
 * 
 * @Version
 * 
 */
public enum WebsocketMessageType {

	ON_LINE(0, "上线"), SEND(1, "发送消息"),MESSAGE(2,"查看消息");
	private int index;
	private String chineseName;

	private WebsocketMessageType(int index, String chineseName) {
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
