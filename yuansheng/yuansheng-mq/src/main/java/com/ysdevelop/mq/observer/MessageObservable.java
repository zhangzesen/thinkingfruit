package com.ysdevelop.mq.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.apache.log4j.Logger;
/**
 * 
 * @author oldHuang
 *
 * @Package com.ysdevelop.mq.observer
 * 
 * @Description 消息队列主题类,通过继承此类变成被观察者
 *
 * @Date 2018年4月27日
 *
 * @Version
 *
 */
public class MessageObservable {

	Logger logger = Logger.getLogger(this.getClass());

	private List<MessageObserver> messageObservers;

	private boolean change = false;
	
	
	public MessageObservable() {
		logger.info("start init message observers");
		messageObservers = new ArrayList<MessageObserver>();
		logger.info("finish init message observers");
	}
	
	public void hasChange(){
		change = true;
	}
	
	public void clearChange(){
		change = false;
	}

	public void addObserver(MessageObserver observer) {
		messageObservers.add(observer);
	}

	public void removeObserver(MessageObserver observer) {
		messageObservers.remove(observer);
	}
	
	
	public void noticeAllObservers(String message) {
		if(!change){
			return ;
		}
		if (message != null && (messageObservers != null && messageObservers.size() > 0)) {
			MessageObserver messageObserver = null;
			for (int i = 0; i < messageObservers.size(); i++) {
				messageObserver = messageObservers.get(i);
				if (messageObserver != null) {
					messageObserver.updateMessage(message);
				}
			}
		}
        clearChange();
	}
}
