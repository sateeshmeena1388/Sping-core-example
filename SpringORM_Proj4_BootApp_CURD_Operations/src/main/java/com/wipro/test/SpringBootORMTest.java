package com.wipro.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;

import com.wipro.config.AopConfig;
import com.wipro.config.PersistanceConfig;
import com.wipro.config.ServiceConfig;
import com.wipro.dto.EmployeeDTO;
import com.wipro.service.EmployeeService;
@SpringBootApplication
@Import(value={PersistanceConfig.class,ServiceConfig.class,AopConfig.class})
public class SpringBootORMTest 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx=null;
        EmployeeDTO dto=null;
        EmployeeService service=null;
       ctx=SpringApplication.run(SpringBootORMTest.class, args);
    service=ctx.getBean("empService",EmployeeService.class);
    //preapared dto
    dto=new EmployeeDTO();
    dto.setFname("frag");dto.setLname("yrja");dto.setEmail("mail.raja@gmail.com");
    //invoke b.method
    System.out.println("Register Emp:"+service.registeration(dto));
     ((AbstractApplicationContext) ctx).close();   
        
    }
}
