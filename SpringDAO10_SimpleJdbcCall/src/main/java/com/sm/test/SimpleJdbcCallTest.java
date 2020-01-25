package com.sm.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sm.service.StudentService;



public class SimpleJdbcCallTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ctx=new FileSystemXmlApplicationContext("src/main/java/com/sm/cfgs/applicationContext.xml");
        StudentService  service=ctx.getBean("stService",StudentService.class);
        
        System.out.println("Registor emp::"+service.searchStudentByNo(8888));
        ((AbstractApplicationContext) ctx).close();
	}

}
