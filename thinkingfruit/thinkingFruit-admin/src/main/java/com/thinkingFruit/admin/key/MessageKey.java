
package com.thinkingFruit.admin.key;

import com.ysdevelop.common.redis.BasePrefix;

public class MessageKey extends BasePrefix {

	public MessageKey(int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
	}

	public static MessageKey messageKey = new MessageKey(0, "Cash");
}