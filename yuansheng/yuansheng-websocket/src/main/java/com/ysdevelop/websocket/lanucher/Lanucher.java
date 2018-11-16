package com.ysdevelop.websocket.lanucher;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lanucher {
	public static void main(String[] args) {
		// 启动spring 容器
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "yuansheng-common.xml","yuansheng-mq.xml","yuansheng-websocket.xml" });
  
	}
}
