package com.thinkingFruit.client.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/** 
 * 登录认证的拦截器 
 */
public class LoginInterceptor implements HandlerInterceptor {
	 /** 
	  * Handler执行完成之后调用这个方法 
	  */
	 public void afterCompletion(HttpServletRequest request, 
	   HttpServletResponse response, Object handler, Exception exc) 
	   throws Exception { 
	    
	 } 
	  
	 /** 
	  * Handler执行之后，ModelAndView返回之前调用这个方法 
	  */
	 public void postHandle(HttpServletRequest request, HttpServletResponse response, 
	   Object handler, ModelAndView modelAndView) throws Exception { 
	 } 
	  
	 /** 
	  * Handler执行之前调用这个方法 
	  */
	 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
	   Object handler) throws Exception { 
	  //获取请求的URL 
	  String url = request.getRequestURI(); 
	  System.out.println("url:"+url);
	  //URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制 
	  if(url.indexOf("login")>=0){ 
	   return true; 
	  } 
	  if(url.indexOf("register")>=0){ 
		   return true; 
	  }
	  //获取Session 
	  HttpSession session = request.getSession(); 
	  Long agentId = (Long) session.getAttribute("agentId"); 
	    
	  if(agentId != null){ 
	   return true; 
	  } 
	  //不符合条件的，跳转到登录界面 
	  request.getRequestDispatcher("/agent/login").forward(request, response); 
	    
	  return false; 
	 } 

}
