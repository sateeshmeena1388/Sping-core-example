package com.mhb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.mhb.dto.StudentDTO;
import com.mhb.service.StudentService;

public class ListStudentController  extends AbstractController{
private StudentService studentService;

	public void setStudentService(StudentService studentService) {
	this.studentService = studentService;
}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		List<StudentDTO> listdto=null;
		ModelAndView mav=null;
		//use service
		listdto=studentService.FetchAllStudentData();
		System.out.println(listdto.size());
		mav=new ModelAndView();
		mav.addObject("studList",listdto);
		mav.setViewName("list_student");
		return mav;
	}

}
