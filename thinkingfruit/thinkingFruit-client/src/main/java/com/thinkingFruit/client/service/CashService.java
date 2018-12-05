package com.thinkingFruit.client.service;

import java.util.List;

import com.thinkingFruit.client.entity.Cash;

/**
 * @author zhangzesen
 *
 * @date 2018年12月5日
 *
 * @package com.thinkingFruit.client.service
 *
 * @description 提现
 */
public interface CashService {
	
	/**
	 * 提现
	 * @param cash 提现实体类
	 */
	void withdrawal(Cash cash);
	
	/**
	 * 获取提现记录列表
	 * @param memberId 代理id
	 * @return 提现集合
	 */
	List<Cash> list(Long memberId);

}
