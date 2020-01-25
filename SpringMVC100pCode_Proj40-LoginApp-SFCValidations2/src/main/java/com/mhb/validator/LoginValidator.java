package com.mhb.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mhb.command.UserCommand;

@Component("validator")
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(UserCommand.class);
	}

	@Override
	public void validate(Object command, Errors errors) {
		// TODO Auto-generated method stub
		UserCommand cmd=null;
		//type casting
		cmd=(UserCommand)command;
		//write Validation logic
		if(cmd.getUser().equals(""))
			errors.rejectValue("user","login.user");
		if(cmd.getPwd().equals(""))
			errors.rejectValue("pwd","login.pwd");
		else{
			if(cmd.getPwd().length()<4)
				errors.rejectValue("pwd","login.pwd.size");
		}
	}

}
