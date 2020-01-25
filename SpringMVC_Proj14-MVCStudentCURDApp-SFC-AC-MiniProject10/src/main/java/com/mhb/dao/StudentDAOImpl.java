package com.mhb.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mhb.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
private static final String GETALL_Student="SELECT * FROM STUDENT";
private static final String GET_STUDENT_BY_NO="SELECT SNO,SNAME,SADD FROM STUDENT WHERE SNO=?";
private static final String UPDATE_STUDENT_BY_NO="UPDATE STUDENT SET SNAME=?,SADD=? WHERE SNO=?";
private static final String DELETE_STUDENT_BY_NO="DELETE FROM STUDENT WHERE SNO=?";
private static final String INSERT_STUDENT_BY_NO="INSERT INTO STUDENT VALUES(?,?,?)";
private static final String GET_SNO_BY_SEQUENCE="SELECT STUDENT_SNO_SEQUENCE.NEXTVAL FROM DUAL";
private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
	this.jt = jt;
}
	@Override
	public List<StudentBO> getAllStudent() {
		// TODO Auto-generated method stub
		List<StudentBO> listbo=null;
		System.out.println(jt.getDataSource());
		listbo=jt.query(GETALL_Student, rs->{
			List<StudentBO> listStbo=null;
			listStbo=new ArrayList<>();
			StudentBO bo=null;
			while(rs.next()){
				bo=new StudentBO();
				bo.setSno(rs.getInt(1));
				bo.setSname(rs.getString(2));
				bo.setSadd(rs.getString(3));
				listStbo.add(bo);
				System.out.println(listStbo.size());
			}
			return listStbo;
		}
		);
		
		return listbo;
	}
	@Override
	public StudentBO getStudentByNo(int no) {
		// TODO Auto-generated method stub
		StudentBO bo=null;
		try{
		bo=jt.queryForObject(GET_STUDENT_BY_NO,(rs,index)->{
			StudentBO stBo=null;
			stBo=new StudentBO();
			stBo.setSno(rs.getInt(1));
			stBo.setSname(rs.getString(2));
			stBo.setSadd(rs.getString(3));
			System.out.println("--------------------"+rs.getFetchSize()+"-------------"+index);
			return stBo;
			
		},no);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return bo ;
	}
	@Override
	public int updateStudentByNo(StudentBO bo) {
		int count=0;
		count=jt.update(UPDATE_STUDENT_BY_NO,bo.getSname(),bo.getSadd(),bo.getSno());
		return count;
	}

	@Override
	public void deleteStudentByNo(int no) {
		 // define query arguments
        Object[] params = { no };
 
   
        // define SQL types of the arguments
        int[] types = {Types.BIGINT};
		// TODO Auto-generated method stub
		jt.update(DELETE_STUDENT_BY_NO,params,types);
	
		
	}
	@Override
	public int generateStudentNumber() {
		// TODO Auto-generated method stub
		int sno=0;
		sno=jt.queryForObject(GET_SNO_BY_SEQUENCE, Integer.class);
		return sno;
	}
	@Override
	public int insertStudent(StudentBO bo) {
		// TODO Auto-generated method stub
		int count=0;
		count=jt.update(INSERT_STUDENT_BY_NO,bo.getSno(),bo.getSname(),bo.getSadd());
		return count;
	}

}
