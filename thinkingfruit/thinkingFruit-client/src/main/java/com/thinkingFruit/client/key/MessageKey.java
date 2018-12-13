
package com.thinkingFruit.client.key;

import com.ysdevelop.common.redis.BasePrefix;

/**
 * @author zhangzesen
 *
 * @date 2018年11月26日
 *
 * @package com.thinkingFruit.admin.key
 *
 * @description 
 */
public class MessageKey extends BasePrefix {

	public MessageKey(int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
	}

	public static MessageKey messageKey = new MessageKey(0, "Message");
}