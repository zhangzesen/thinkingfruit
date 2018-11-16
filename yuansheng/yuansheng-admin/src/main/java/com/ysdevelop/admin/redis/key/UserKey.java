package com.ysdevelop.admin.redis.key;

import com.ysdevelop.common.redis.BasePrefix;

public class UserKey extends BasePrefix {

	private UserKey(int expireSeconds, String prefix) {
		super(expireSeconds,prefix);
	}

	public static UserKey userKey = new UserKey(0, "user");
	
}
