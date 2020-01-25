package com.sm.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sm.dto.StudentDTO;
import com.sm.service.StudentService;



public class MappingSql_OperationTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ctx=new FileSystemXmlApplicationContext("src/main/java/com/sm/cfgs/applicationContext.xml");
        StudentService  service=ctx.getBean("stService",StudentService.class);
        StudentDTO dto=new StudentDTO();
        dto.setSno(101);dto.setSname("rohit");dto.setSadd("chennai");
        System.out.println("Registor emp::"+service.searchByAddrs("chennai"));
        System.out.println("Find Emp "+service.serachStudentByNo(8888));
        System.out.println("bject modified "+service.modifyStudentByNo(dto));
        ((AbstractApplicationContext) ctx).close();
	}

}
