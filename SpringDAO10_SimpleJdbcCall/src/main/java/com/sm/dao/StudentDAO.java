package com.sm.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.sm.bo.StudentBo;

public class StudentDAO {
private SimpleJdbcCall sjc;

public void setSjc(SimpleJdbcCall sjc) {
	this.sjc = sjc;
}
public StudentBo getStudentDetails(int id){
	sjc.setProcedureName("get_Details");
	System.out.println("--------------");
	Map<String,Object> inParam=new HashMap<String,Object>();
	inParam.put("no", id);
	//prepared In param 
	Map<String,Object> outParam=sjc.execute(inParam);
	
	StudentBo bo=new StudentBo(id,(String)outParam.get("sname"),(String)outParam.get("sadd"));
	return bo;
}
}
