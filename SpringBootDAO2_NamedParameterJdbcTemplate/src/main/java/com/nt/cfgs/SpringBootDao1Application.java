package com.nt.cfgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.nt.service.EmpService;

@SpringBootApplication
@ComponentScan(basePackages={"com.nt.service","com.nt.dao"})
public class SpringBootDao1Application {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmpService service=null;
		ctx=SpringApplication.run(SpringBootDao1Application.class, args);
		//get service bean
		service=ctx.getBean("empService",EmpService.class);
		System.out.println("EmpCount "+service.findEmpcount());
		System.out.println("Employee records by desg: "+service.findEmployeeByDesg("sw"));
		((ConfigurableApplicationContext) ctx).close();
	}
}
