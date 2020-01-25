package com.mhb.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mhb.command.StudentCommand;

public final class StudentCommandValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(StudentCommand.class);
	}

	@Override
	public void validate(Object cmd, Errors errors) {
		// TODO Auto-generated method stub
		StudentCommand command=null;
		command=(StudentCommand) cmd;
		if(command.getSno()<=0)
			errors.rejectValue("sno", "sno.required");
		if(command.getSname()==null||command.getSname().length()==0)
			errors.rejectValue("sname", "sname.required");
		if(command.getSadd()==null||command.getSadd().length()==0)
			errors.rejectValue("sadd", "sadd.required");
		else
		{
			if(command.getSadd().length()<5)
				errors.rejectValue("sadd", "sadd.minimum");
		}
		
	}

}
