package com.mhb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.mhb.command.StudentCommand;
import com.mhb.dto.StudentDTO;
import com.mhb.service.StudentService;

@SuppressWarnings("deprecation")
public class InsertStudentController extends SimpleFormController {
private StudentService service;

public void setService(StudentService service) {
	this.service = service;
}

@Override
public Object formBackingObject(HttpServletRequest request) throws Exception {
	// TODO Auto-generated method stub
int no=0;
StudentDTO dto=null;
StudentCommand cmd=null;
//read student no from edit hyperlink "sid"
no=service.fetchstudentNumber();
cmd=new StudentCommand();
cmd.setSno(no);

	return cmd;
}
@Override
public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
		BindException errors) throws Exception {
	// TODO Auto-generated method stub
StudentCommand cmd=null;
StudentDTO dto=null;
String result=null;
ModelAndView mav=null;
List<StudentDTO> listDto=null;

cmd=(StudentCommand) command;
dto=new StudentDTO();
//convert command obj to DTO object
BeanUtils.copyProperties(cmd,dto);
//use serice 
result=service.registerStudent(dto);
listDto=service.FetchAllStudentData();
//create mav object
mav=new ModelAndView();
mav.addObject("insert_students",result);
mav.setViewName("list_student");
mav.addObject("studList",listDto);
mav.addObject("stCmd",cmd);

	return mav;
}

}
