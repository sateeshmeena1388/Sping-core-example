package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.nt.bo.EmpBO;

public class EmpDAO {
	
	private SimpleJdbcInsert sjt;
	
	public void setSjt(SimpleJdbcInsert sjt) {
		this.sjt = sjt;
	}
	public int insertRecord(EmpBO ebo){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("eno", ebo.getEno());
		map.put("ename", ebo.getEname());
		map.put("job",ebo.getJob());
		map.put("sal", ebo.getSal());
		sjt.setTableName("emp1");
		int result=sjt.execute(map);
		return result;
		
	}
	
}
