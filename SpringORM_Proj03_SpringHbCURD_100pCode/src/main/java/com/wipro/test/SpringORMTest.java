package com.wipro.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.wipro.config.AppConfig;
import com.wipro.dto.EmployeeDTO;
import com.wipro.service.EmployeeService;

public class SpringORMTest 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx=null;
        EmployeeDTO dto=null;
        EmployeeService service=null;
       ctx=new AnnotationConfigApplicationContext(AppConfig.class);
    service=ctx.getBean("empService",EmployeeService.class);
    //preapared dto
    dto=new EmployeeDTO();
    dto.setFname("fragia");dto.setLname("yraja");dto.setEmail("mail.raja@gmail.com");
    //invoke b.method
    System.out.println("Register Emp:"+service.registeration(dto));
     ((AbstractApplicationContext) ctx).close();   
        
    }
}
