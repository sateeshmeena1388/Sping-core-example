package com.mhb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

@SuppressWarnings("deprecation")
public class RegisterController extends AbstractWizardFormController {

	@Override
	public ModelAndView processFinish(HttpServletRequest req, HttpServletResponse res, Object cmd,
			BindException bind) throws Exception {
		// TODO Auto-generated method stub
		//Acually we need to Convert Cmd obj to DTO obj and needs to send to Service class
				//But here we are just keeping Cmd obj in model attribute check wheather all 3 forms
				// data is stored or not.
		return new ModelAndView("result","cmdData",cmd);
	}
	@Override
	protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		// TODO Auto-generated method stub
		return new ModelAndView("form1","regCmd",command);
	}
}
