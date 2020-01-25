package com.mhb.handler;

import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("dpi")
public class DoublePostingHandler extends HandlerInterceptorAdapter {
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("PreHandler(-) method......");
		int sToken=0,cToken=0;
		HttpSession session=null;
		RequestDispatcher rd=null;
		if(request.getMethod().equalsIgnoreCase("GET"))
		{
			if (request.getSession() == null)
				session = request.getSession(true);
			else
				session = request.getSession(false);
			// create Serverside token
			session.setAttribute("sToken", new Random().nextInt(10000));
			return true;
		}
   
       else
       
            {
			
			//when form is submitted or when refresh button is clicked
			//read both client and serverside tokens
			session=request.getSession(false);
		sToken=(Integer) session.getAttribute("sToken");
		cToken=Integer.parseInt(request.getParameter("cToken"));
		if(sToken==cToken){
			session.setAttribute("sToken", new Random().nextInt(10000));
			return true;
		}
		else{
			System.out.println("-------------");
			rd=request.getRequestDispatcher("dbl_posting.jsp");
			rd.forward(request, response);
			return false;
		}
		}
		
	}
}
