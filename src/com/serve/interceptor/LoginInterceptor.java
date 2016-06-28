package com.serve.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	
	private List<String> allowpath;
	
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		//ÅÐ¶ÏÓÃ»§ÊÇ·ñµÇÂ¼
		Object username = arg0.getSession().getAttribute("name");		
		if(username != null)
			return true;
		
		String url = arg0.getRequestURL().toString();
		for(String temp : allowpath){
			if(url.endsWith(temp))
				return true;
		}
		arg1.sendRedirect("/musicstore/user/login");
		return false;
	}
	
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
		
	}
	
	public void setAllowpath(List<String> allowpath) {
		this.allowpath = allowpath;
	}

}
