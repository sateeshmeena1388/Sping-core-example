package com.nt.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

public class BachProcessingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=null;
		ctx= new FileSystemXmlApplicationContext("src/main/java/com/nt/cfgs/applicationContext.xml");
StudentService service=ctx.getBean("stService",StudentService.class);
StudentDTO dto =new StudentDTO(8888,"satish", "chennai");
StudentDTO dto1 =new StudentDTO(8455,"satish", "chennai");
StudentDTO dto2 =new StudentDTO(6254,"satish", "chennai");
StudentDTO dto3 =new StudentDTO(5666,"satish", "chennai");
List<StudentDTO> student=new ArrayList<StudentDTO>();
student.add(dto);
student.add(dto1);
student.add(dto2);
student.add(dto3);

//call b.method
String result=service.registStudent(student);
System.out.println(result);
((AbstractApplicationContext) ctx).close();
	}

}