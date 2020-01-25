package com.mhb.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mhb.bo.UserBO;
import com.mhb.dao.UserDAO;
import com.mhb.dto.UserDTO;
@Service("loginSerice")
public class LoginServiceImpl implements LoginService {
	@Autowired
private UserDAO dao;
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true ,transactionManager="dsTxMgr")
	public String authenticate(UserDTO dto) {
		// TODO Auto-generated method stub
		UserBO bo=null;
		int count=0;
		bo=new UserBO();
		BeanUtils.copyProperties(dto, bo);
		count=dao.validate(bo);
		System.out.println("------------"+count);
		if(count==0){
			return "Invalid Credentials";
		}
		else
		{
		return " Valid Credential";
		}
	}

}
