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

public class DeleteStudentController extends SimpleFormController {

	// TODO Auto-generated method stub
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
		String delete_result=null;
	ModelAndView mav=null;
	List<StudentDTO> listDto=null;
	cmd=(StudentCommand) command;
	dto=new StudentDTO();
	//convert command obj to DTO object
	//BeanUtils.copyProperties(cmd,dto);
	int no=cmd.getSno();
	//use serice 
	delete_result=service.removeStudentBy_Sno(no);
	listDto=service.FetchAllStudentData();
	//create mav object
	mav=new ModelAndView();
	mav.setViewName("delete_student");
	mav.addObject("studList",listDto);
	mav.addObject("delete_student",delete_result);
			return mav;
		}
}

