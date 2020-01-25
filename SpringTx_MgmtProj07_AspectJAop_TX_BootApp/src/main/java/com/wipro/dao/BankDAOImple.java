package com.wipro.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository("bankDao")
public class BankDAOImple implements BankDAO {
private static final String WITHDRAW_QUERY="UPDATE ACCOUNT SET BALANCE=BALANCE-? WHERE ACCNO=?";
private static final String DEPOSITE_QUERY="UPDATE ACCOUNT SET BALANCE =BALANCE+? WHERE ACCNO=?";
@Autowired
private JdbcTemplate jt;
	@Override
	public int withdraw(int accNo, float amount) {
		int count =0;
		count=jt.update(WITHDRAW_QUERY,amount,accNo);
		return count;
	}

	@Override
	public int deposite(int accNo, float amount) {
		// TODO Auto-generated method stub
		int count=0;
		count=jt.update(DEPOSITE_QUERY,amount,accNo);
		return count;
	}

}
