package com.thinkingFruit.client.mapper;

import java.util.List;

import com.thinkingFruit.client.entity.Cash;

/**
 * @author zhangzesen
 *
 * @date 2018年12月5日
 *
 * @package com.thinkingFruit.client.mapper
 *
 * @description 提现
 */
public interface CashDao {
	
	/**
	 * 提现
	 * @param cash 提现实体类
	 * @return
	 */
	Integer withdrawal(Cash cash);
	
	/**
	 * 获取提现列表
	 * @param memberId 代理id
	 * @return 提现记录集合
	 */
	List<Cash> list(Long memberId);

}
