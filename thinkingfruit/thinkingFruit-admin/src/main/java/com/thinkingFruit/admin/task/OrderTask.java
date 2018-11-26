package com.thinkingFruit.admin.task;

/**
 * @author zhangzesen
 *
 * @date 2018年11月26日
 *
 * @package com.thinkingFruit.admin.task
 *
 * @description 定时
 */
public interface OrderTask {
	/**
	 * 提货订单超时自动完成
	 */
	void orderCompletion();

}
