package com.sm.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sm.dao.ListEmployeeDAO;
import com.sm.service.EmployeeService;

public class EmpTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ApplicationContext ctx=null;
ctx=new FileSystemXmlApplicationContext("src/main/java/com/sm/cfgs/applicationContext.xml");
//get bean
EmployeeService service=(EmployeeService) ctx.getBean("empService");
//System.out.println("7499 Emp details" + service.searchEmpByNo(7488));
System.out.println("Find Clerk Emp: "+service.searchEmpByDesg("CLERK"));
	}
}
