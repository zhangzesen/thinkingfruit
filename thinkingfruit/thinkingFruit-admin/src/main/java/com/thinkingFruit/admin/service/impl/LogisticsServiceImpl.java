package com.thinkingFruit.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkingFruit.admin.entity.Logistics;
import com.thinkingFruit.admin.mapper.LogisticsDao;
import com.thinkingFruit.admin.service.LogisticsService;


/**
 * @author zhangzesen
 *
 * @date 2018年11月26日
 *
 * @package com.thinkingFruit.admin.service.impl
 *
 * @description 物流
 */
@Service
public class LogisticsServiceImpl implements LogisticsService{

	@Autowired
	LogisticsDao logisticsDao;
	
	/**
	 * 	获取所有物流信息
	 */
	@Override
	public List<Logistics> get() {
		return logisticsDao.getLogistics();
	}

}
