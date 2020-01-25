package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.service.EmpService;

public class SimpleJdbcInserTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ctx=new FileSystemXmlApplicationContext("src/main/java/com/nt/cfgs/applicationContext.xml");
        EmpService service=ctx.getBean("stService",EmpService.class);
        
        System.out.println("Registor emp::"+service.registorEmp("5578", "Suesh","Dev", "4505.0f"));
        ((AbstractApplicationContext) ctx).close();
	}

}
