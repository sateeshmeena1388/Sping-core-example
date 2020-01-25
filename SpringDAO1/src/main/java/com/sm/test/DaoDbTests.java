package com.sm.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sm.service.DBOperationsService;

public class DaoDbTests {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx=null;
	ctx= new FileSystemXmlApplicationContext("src/main/java/com/sm/cfgs/applicationContext.xml");
	
	DBOperationsService service=ctx.getBean("DbService",DBOperationsService.class);
	
	
	System.out.println("9001 Emp Details"+ service.registarEmp(6629, "rakesh", "CLERK", 50000));
	System.out.println("9001 Emp Details"+ service.registarEmp(7899, "rakesh", "CLERK", 60000));
	//System.out.println("Getting salary of 7456::"+service.showSalary(7456));
	//System.out.println("Getting info of emp::"+service.getEmpdetails(7456));
	//System.out.println("Getting All emop list"  +service.getAllEmpDetails());
	//System.out.println("Update salary" +service.hikeSalary(7456));
	//System.out.println("Fire emp from comany:: "+service.fireEmp(7456));
	}

}
