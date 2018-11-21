package com.thinkingFruit.admin.mapper;

import java.util.List;

import com.thinkingFruit.admin.entity.Logistics;


/**
 * @author zhangzesen
 *
 * @date 2018年11月20日
 *
 * @package com.thinkingFruit.admin.mapper
 *
 * @description 物流
 */
public interface LogisticsDao {
	/**
	 * 	获取所有物流
	 * @return 物流集合
	 */
	List<Logistics> getLogistics();

}
