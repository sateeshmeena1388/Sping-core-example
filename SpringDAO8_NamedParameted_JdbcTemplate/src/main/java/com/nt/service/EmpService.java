package com.nt.service;

import com.nt.bo.EmpBO;
import com.nt.dao.EmpDAO;
import com.nt.dto.EmpDTO;

public class EmpService {
private EmpDAO dao;

public void setDao(EmpDAO dao) {
	this.dao = dao;
}
public String searchNamedByNo(int no){
	//use dao
	String name=dao.findName(no);
	return name;
}
public EmpDTO searchEmpByNo(int no){
	EmpBO bo=dao.findEmpDetails(no);
	EmpDTO dto=new EmpDTO(bo.getEno(), bo.getEname(), bo.getJob(), bo.getSal());
	return dto;
}

public String registorEmp(int eno,String name,String job,float sal){
	EmpDTO dto=new EmpDTO(eno, job, job, sal);
	EmpBO bo=new EmpBO(dto.getEno(),dto.getEname(),dto.getJob(),dto.getSal());
	//use dao
	int result=dao.insertRecord(bo);
	if(result==1)
		return "Regisration Successful";
	else
		return "Registration failed";
}
}
