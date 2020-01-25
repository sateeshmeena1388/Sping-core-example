package com.wipro.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wpro.domain.EmployeeHLO;
@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String HQL_GET_EMPS="FROM EMPLOYEEHLO";
	
	private static final String HQL_UPDATE_EMAIL_BY_NO="UPDATE EMPLOYEEHLO SET EMAIL=? WHERE EID=?";
	
	private static final String HQL_DELETE_EMPS_BY_LASTNAME="DELETE FROM EMPLOYEEHLO WHERE LASTNAME=:LNAME";
	
	private static final String HQL_GET_EMPS_BY_EMAIL_DOMAIN="FROM EMPLOYEEHLO WHERE EMAIL LIKE:DMN";
	@Resource
	private HibernateTemplate ht;

	

	@Override
	public int insertRecords(EmployeeHLO emp) {
		int idVal=0;
		idVal=(int) ht.save(emp);
		// TODO Auto-generated method stub
		return idVal;
	}

	@Override
	public List<EmployeeHLO> getAllEmployees() {
		//List<EmployeeHLO> listHLO;
		//listHLO=(List<EmployeeHLO>) ht.find(HQL_GET_EMPS);
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeHLO> getEmployeesByLastName( String lName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeHLO> getEmployeesByEmailDomain(String domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateEmployeeEmail(int empid, String newMail) {
		// TODO Auto-generated method stub
		
		return ht.bulkUpdate(HQL_UPDATE_EMAIL_BY_NO, newMail,empid);
	}

	@Override
	public int deleteEmployeeByEmpId(int empId) {
		// TODO Auto-generated method stub
		int count=0;
		
		return 0;
	}

	@Override
	public int deleteEmployeeByName(String surname) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<EmployeeHLO> getEmployeesByLastName(String surname, String surname2, String surname3) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	

}
