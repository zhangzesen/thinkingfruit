package com.ysdevelop.shiro.filter;

import java.io.Serializable;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import com.ysdevelop.shiro.entity.User;

public class KickoutSessionControlFilter extends AccessControlFilter {

	private final static String CACHE_NAME = "shiro-kickout-session";

	private String kickoutUrl; // 踢出后到的地址
	private boolean kickoutAfter = true; // 踢出之前登录的/之后登录的用户 默认踢出之前登录的用户
	private int maxSession; // 同一个帐号最大会话数 默认1

	private SessionManager sessionManager;
	private static Cache<String, Deque<Serializable>> cache;
	private String cacheName = CACHE_NAME;
	
	
	public void setKickoutUrl(String kickoutUrl) {
		this.kickoutUrl = kickoutUrl;
	}

	public void setKickoutAfter(boolean kickoutAfter) {
		this.kickoutAfter = kickoutAfter;
	}

	public void setMaxSession(int maxSession) {
		this.maxSession = maxSession;
	}

	public void setSessionManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}

	public void setCacheManager(CacheManager cacheManager) {
		cache = cacheManager.getCache(cacheName);
	}
	
	public String getCacheName() {
		return cacheName;
	}

	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}

	public static void emptyUserDeque(String userName) {
		cache.get(userName).clear();
	}
	
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		Subject subject = getSubject(request, response);
		// 如果是相关目录 or 如果没有登录 就直接return true
		if (!subject.isAuthenticated() && !subject.isRemembered()) {
			// 如果没有登录，直接进行之后的流程
			return true;
		}

		Session session = subject.getSession();
		User user = (User) subject.getPrincipal();
		Serializable sessionId = session.getId();
		
		 // TODO 同步控制
        Deque<Serializable> deque = cache.get(user.getLoginName());

        if (deque == null) {
        	deque = new ConcurrentLinkedDeque<Serializable>();
        	deque.push(sessionId);
        	cache.put(user.getLoginName(), deque);
        }
        
        // 如果队列里没有此sessionId，且用户没有被踢出；放入队列
        if (!deque.contains(sessionId) && session.getAttribute("kickout") == null) {
        	deque.push(sessionId);
        }
        
		// 如果队列里的sessionId数超出最大会话数，开始踢人
        System.out.println("队列长度"+deque.size());
		while (deque.size() > maxSession) {
			Serializable kickoutSessionId = null;
			if (kickoutAfter) { // 如果踢出后者
				kickoutSessionId = deque.removeLast();
			} else { // 否则踢出前者
				kickoutSessionId = deque.removeFirst();
			}
			try {
				DefaultSessionKey defaultSessionKey = new DefaultSessionKey(kickoutSessionId);
				Session kickoutSession = sessionManager.getSession(defaultSessionKey);
				if (kickoutSession != null) {
					// 设置会话的kickout属性表示踢出了
					kickoutSession.setAttribute("kickout", true);
				}
			} catch (Exception e) {// ignore exception
			}
		}

		// 如果被踢出了，直接退出，重定向到踢出后的地址
		if (session.getAttribute("kickout") != null) {
			// 会话被踢出了
			try {
//				String kickoutId=session.getId().toString();
//				ClientManager.getInstance().removeUser(kickoutId);
				subject.logout();
			} catch (Exception e) { 
				e.printStackTrace();
			}
			saveRequest(request);
			WebUtils.issueRedirect(request, response, kickoutUrl);
			return false;
		}
		return true;
	}

}

