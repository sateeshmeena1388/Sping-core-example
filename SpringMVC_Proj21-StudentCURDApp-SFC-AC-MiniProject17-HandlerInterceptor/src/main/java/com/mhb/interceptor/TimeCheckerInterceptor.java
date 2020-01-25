package com.mhb.interceptor;

import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TimeCheckerInterceptor extends HandlerInterceptorAdapter {
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
	// TODO Auto-generated method stub
	Calendar calendar=null;
	RequestDispatcher rd=null; 
	int hour=0;
	calendar=Calendar.getInstance();
	hour=calendar.get(Calendar.HOUR_OF_DAY);
	if(hour>=9&& hour<=23)
		return true;
	else{
		rd=request.getRequestDispatcher("/timeout.jsp");//place timeout.jsp outside WEB-INF folder
	rd.forward(request,response);
	return false;
	}
}
}
