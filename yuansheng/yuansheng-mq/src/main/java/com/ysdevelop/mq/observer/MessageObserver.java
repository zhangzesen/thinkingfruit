package com.ysdevelop.mq.observer;
/**
 * 
 * @author oldHuang
 *
 * @Package com.ysdevelop.mq.observer
 * 
 * @Description 消息队列观察者接口,实现该接口可以做到观察消息队列观察
 *
 * @Date 2018年4月27日
 *
 * @Version
 *
 */
public interface MessageObserver {
    void updateMessage(String message);
}
