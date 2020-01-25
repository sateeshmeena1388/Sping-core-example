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
public class EditStudentController extends SimpleFormController {
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
	no=Integer.parseInt(request.getParameter("sid"));
	System.out.println(no+"----no-----------------");
	//use service 
	dto= service.fetchStudentBySno(no);
	//create cpmmand object having DTO class object data
	cmd=new StudentCommand();
	BeanUtils.copyProperties(dto, cmd);
		return cmd;
	}
@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		// TODO Auto-generated method stub
	StudentCommand cmd=null;
	StudentDTO dto=null;
	String edit_result=null;
ModelAndView mav=null;
List<StudentDTO> listDto=null;
cmd=(StudentCommand) command;
dto=new StudentDTO();
//convert command obj to DTO object
BeanUtils.copyProperties(cmd,dto);
//use serice 
edit_result=service.modifyStudentByNo(dto);
listDto=service.FetchAllStudentData();
//create mav object
mav=new ModelAndView();
mav.setViewName("list_student");
mav.addObject("studList",listDto);
mav.addObject("edit_student",edit_result);
		return mav;
	}
}
