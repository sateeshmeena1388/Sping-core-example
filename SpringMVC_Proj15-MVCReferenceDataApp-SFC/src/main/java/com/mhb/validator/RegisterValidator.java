package com.mhb.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mhb.command.RegisterCommand;

public class RegisterValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(RegisterCommand.class);
	}

	@Override
	public void validate(Object cmd, Errors errors) {
		// TODO Auto-generated method stub
		RegisterCommand command=null;
		//typcasting
		command=(RegisterCommand) cmd;
		if(command.getName().length()==0)
			errors.rejectValue("name", "name.required");
		if(command.getAddrs().length()==0)
			errors.rejectValue("addrs", "addrs.required");
		if(command.getCountry().length()==0)
			errors.rejectValue("country", "country.required");
		if(command.getCourses()==null||command.getCourses().length==0)
			errors.rejectValue("courses", "courses.required");
			
	}

}
