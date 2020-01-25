package com.mhb.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

@SuppressWarnings("deprecation")
public class RegisterController extends SimpleFormController {
 @Override
public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
	// TODO Auto-generated method stub
	 
	 System.out.println("initBinder(-,-)");
	 SimpleDateFormat sdf=null;
	 sdf=new SimpleDateFormat("dd-MM-yyyy");
	 binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

}
 @Override
	public ModelAndView onSubmit(Object command) throws Exception {
		// TODO Auto-generated method stub
		return new ModelAndView("register_result","cmdData",command);
	}
 
}

