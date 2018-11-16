package com.ysdevelop.common.key;

import com.ysdevelop.common.redis.BasePrefix;

public class RandCodeKey extends BasePrefix{

	public RandCodeKey(int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
	}
    // 1个小时的有效期
	public static RandCodeKey randCodeKey = new RandCodeKey(3600, "query-interval");
	
}
