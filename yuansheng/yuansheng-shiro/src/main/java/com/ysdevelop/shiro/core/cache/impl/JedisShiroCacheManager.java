package com.ysdevelop.shiro.core.cache.impl;

import org.apache.shiro.cache.Cache;



import org.springframework.beans.factory.annotation.Autowired;

import com.ysdevelop.common.redis.JedisManager;
import com.ysdevelop.shiro.core.cache.JedisShiroCache;
import com.ysdevelop.shiro.core.cache.ShiroCacheManager;

public class JedisShiroCacheManager implements ShiroCacheManager {
    
	@Autowired
	private JedisManager jedisManager;

	@Override
	public <K, V> Cache<K, V> getCache(String name) {
		return new JedisShiroCache<K, V>(name, getJedisManager());
	}

	@Override
	public void destroy() {

	}

	public JedisManager getJedisManager() {
		return jedisManager;
	}


}
