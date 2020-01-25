package com.wipro.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.dao.EmployeeDAO;
import com.wipro.dto.EmployeeDTO;
import com.wpro.domain.EmployeeHLO;
@Service("empService")
@Transactional(propagation=Propagation.REQUIRED,readOnly=false,transactionManager="hbTxMgmr")
public class EmployeeServiceImpl implements EmployeeService {
	
@Resource	
private EmployeeDAO dao;


	@Override
	public String registeration(EmployeeDTO dto) {
		
		EmployeeHLO hlo=null;
		int result=0;
		//convert DTO to BO
		hlo=new EmployeeHLO();
		hlo.setEmpid(dto.getEmpid());hlo.setfName(dto.getFname());hlo.setlName(dto.getLname());hlo.setEmail(dto.getEmail());
		//use DAO
		result=dao.insertRecords(hlo);
		if(result==0)
			return "Registration failed";
		else
			return "Employee Registtred with Number" +result;
		
		
	}

	@Override
	public List<EmployeeDTO> fetchAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDTO> fetchEmployeesByEmailDomain(String domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modifyEmailEmploeeByNo(int epid, String newmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeEmployeeByLastName(String surname1, String surname2, String surname3) {
		// TODO Auto-generated method stub
		return null;
	}

}
