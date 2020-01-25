package com.sm.service;


import java.util.List;
import java.util.Map;

import com.sm.dao.EmpDAO;

public class EmpService {
private EmpDAO dao;

public void setDao(EmpDAO dao) {
	this.dao = dao;
}

public List<Map<String,Object>> search(String job[]) {
	// TODO Auto-generated method stub
	StringBuffer sb=new StringBuffer("(");
	for(int i=0;i<job.length;i++){
		if(i==job.length-1){
			sb.append("'"+job[i]+"'");
		}
		else
			sb.append("'"+job[i]+"',");
	}
	
	sb.append(")");
	String condition=sb.toString();
	List<Map<String,Object>> list=dao.getEmpdetails(condition);
	return list ;
	
}

}
