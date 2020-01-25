package com.wipro.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.wipro.dto.EmployeeDTO;
import com.wipro.service.EmployeeService;

public class SpringORMTest 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx=null;
        EmployeeDTO dto=null;
        EmployeeService service=null;
        ctx=new FileSystemXmlApplicationContext("src/main/java/com/wipro/cfgs/applicationContext.xml");
    service=ctx.getBean("empService",EmployeeService.class);
    //preapared dto
    dto=new EmployeeDTO();
    dto.setFname("fragia");dto.setLname("lraja");dto.setEmail("mail.raja@gmail.com");
    //invoke b.method
    System.out.println("Register Emp:"+service.registeration(dto));
     ((AbstractApplicationContext) ctx).close();   
        
    }
}
