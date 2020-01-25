package com.sm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;

import com.sm.bo.StudentBo;


public class StudentDAOImpl implements StudentDAO {
	private static final String GET_STUDENT_BY_ADDRESS = "select * from student where sadd=?";
	private static final String GET_STUDENT_BY_NO = "SELECT NO,NAME,SADD FROM STUDENT WHERE NO=?";
	private static final String UPDATE_STUDENT_QUERY ="UPDATE STUDENT1 SET  SNAME=?, SADD=? WHERE SNO=?";
	private DataSource ds;
	private StudentSelector selector;
	private StudentSelector1 selector1;
	private StudentUpdator updator;

	public StudentDAOImpl(DataSource ds) {
		super();
		this.ds = ds;
		selector = new StudentSelector(ds, GET_STUDENT_BY_ADDRESS);
		selector1 = new StudentSelector1(ds, GET_STUDENT_BY_NO);
		updator = new StudentUpdator(ds, UPDATE_STUDENT_QUERY);

	}

	@Override
	public List<StudentBo> getStudentByAddrs(String addrs) {
		// TODO Auto-generated method stub
		List<StudentBo> listbo = null;
		listbo = selector.execute(addrs);
		return listbo;
	}

	@Override
	public StudentBo getStudentByNo(int no) {
		// TODO Auto-generated method stub
		StudentBo bo = null;
		bo = (StudentBo) selector1.findObject(no);
		return bo;
	}

	@Override
	public int UpdateStudentDetailsByNo(StudentBo bo) {
		
		int count=0;
		count=updator.update(bo.getNo(),bo.getName(),bo.getSadd());
				
		return count;
	}

	private static final class StudentSelector extends MappingSqlQuery<StudentBo> {

		public StudentSelector(DataSource ds, String qry) {
			// TODO Auto-generated constructor stub
			super(ds, qry);
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.compile();
		}

		@Override
		protected StudentBo mapRow(ResultSet rs, int index) throws SQLException {
			// TODO Auto-generated method stub
			StudentBo bo = null;
			bo = new StudentBo();
			bo.setNo(rs.getInt(1));
			bo.setName(rs.getString(2));
			bo.setSadd(rs.getString(3));
			return bo;
		}

	}

	private static final class StudentSelector1 extends MappingSqlQuery {
		public StudentSelector1(DataSource ds, String qry) {
			super(ds, qry);
			super.declareParameter(new SqlParameter(Types.INTEGER));
			super.compile();
			// TODO Auto-generated constructor stub
		}

		@Override
		protected Object mapRow(ResultSet rs, int index) throws SQLException {
			// TODO Auto-generated method stub
			StudentBo bo = null;
			bo = new StudentBo();
			bo.setNo(rs.getInt(1));
			bo.setName(rs.getString(2));
			bo.setSadd(rs.getString(3));
			return bo;

		}

	}

	private static final class StudentUpdator extends SqlUpdate {
		public StudentUpdator(DataSource ds, String qry) {
			super(ds, qry);
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.declareParameter(new SqlParameter(Types.INTEGER));
			
			
			
			super.compile();
			// TODO Auto-generated constructor stub
		}
	}

}
