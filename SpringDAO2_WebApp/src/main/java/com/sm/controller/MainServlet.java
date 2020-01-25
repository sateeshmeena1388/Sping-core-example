package com.sm.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sm.service.EmpService;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static ApplicationContext ctx=null;
    private static EmpService service;
       
   public void init(){
    	   //create IOC container
    	   ctx=new ClassPathXmlApplicationContext("com/sm/cfgs/applicationContext.xml");
    	// TODO Auto-generated method stub
    	   service=(EmpService) ctx.getBean("service");
   }	
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        System.out.println("Controller");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String jobs[]=request.getParameterValues("job");
		//use service
		System.out.println(service);
		List<Map<String,Object>> list=service.search(jobs);
		request.setAttribute("result", list);
		//forward the request to result page
		RequestDispatcher rd=request.getRequestDispatcher("/result.jsp");
		rd.forward(request,response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
@Override
public void destroy() {
	// TODO Auto-generated method stub
	service=null;
	((AbstractApplicationContext) ctx).close();
}
}
