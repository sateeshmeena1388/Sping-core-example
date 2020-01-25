package com.nt.service;

import com.nt.bo.EmpBO;
import com.nt.dao.EmpDAO;
import com.nt.vo.EmpVO;

public class EmpService {
private EmpDAO dao;

public void setDao(EmpDAO dao) {
	this.dao = dao;
}


public String registorEmp(String eno,String name,String job,String sal){
	
	EmpVO vo=new EmpVO(eno, name, job, sal);
	//use dao
	//convert  vo object bo
	EmpBO bo=new EmpBO();
	bo.setEno(Integer.parseInt(vo.getEno()));
	bo.setEname(vo.getName());
	bo.setJob(vo.getJob());
	bo.setSal(Float.parseFloat(vo.getSal()));
	int result=dao.insertRecord(bo);
	if(result==1)
		return "Regisration Successful";
	else
		return "Registration failed";
}
}
