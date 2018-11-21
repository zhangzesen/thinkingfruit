package com.thinkingFruit.admin.service;

import java.util.List;

import com.thinkingFruit.admin.entity.Logistics;


/**
 * @author zhangzesen
 *
 * @date 2018年11月20日
 *
 * @package com.thinkingFruit.admin.service
 *
 * @description 物流
 */
public interface LogisticsService {
	
	/**
	 * 	获取所有物流信息
	 * @return 物流集合
	 */
	List<Logistics> get();
	
}
