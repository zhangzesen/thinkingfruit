package com.thinkingFruit.admin.task.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.thinkingFruit.admin.entity.Order;
import com.thinkingFruit.admin.mapper.MessageDao;
import com.thinkingFruit.admin.service.OrderService;
import com.thinkingFruit.admin.task.OrderTask;
import com.ysdevelop.common.utils.Constant;

/**
 * @author zhangzesen
 *
 * @date 2018年11月26日
 *
 * @package com.thinkingFruit.admin.task.impl
 *
 * @description 定时任务
 */
@Component
public class OrderTaskImpl implements OrderTask{

	@Autowired
	OrderService orderService;
	
	@Autowired
	MessageDao messageDao;
	/**
	 * 提货订单完成消息，修改订单状态
	 */
	@Scheduled(cron="0 0 2 * * ?")
	@Override
	public void orderCompletion() {
        long currentTime = System.currentTimeMillis();
        List<Order> orders = orderService.findUnreceivedOrder();
        if(orders!=null) {
        	List<String> contents=new ArrayList<>();
        	String content=null;
        	for(int i=orders.size()-1;i>=0;i--) {
        		if((currentTime-orders.get(i).getConfirmTime().getTime())<(10*24*3600*1000)){
        			orders.remove(orders.get(i));
        		}else {
        			content="订单:"+orders.get(i).getOrderNo()+"已完成";
        			contents.add(content);
        		}
        	}
        	if(orders.size() >= Constant.DEFALULT_ONE){
        		orderService.updateBatchByOrders(orders);
        		messageDao.addMessageList(contents);
        	}
        }
	}
}
