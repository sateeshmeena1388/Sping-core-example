package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.service.EmpService;

public class NamedParametedTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ctx=new FileSystemXmlApplicationContext("src/main/java/com/nt/cfgs/applicationContext.xml");
        EmpService service=ctx.getBean("stService",EmpService.class);
        System.out.println("7788 emp name ::"+service.searchNamedByNo(7788));
        System.out.println("2024 emp details::"+service.searchEmpByNo(2024));
        System.out.println("Registor emp::"+service.registorEmp(8399, "Suesh", "Developer", 45055.0f));
        ((AbstractApplicationContext) ctx).close();
	}

}
