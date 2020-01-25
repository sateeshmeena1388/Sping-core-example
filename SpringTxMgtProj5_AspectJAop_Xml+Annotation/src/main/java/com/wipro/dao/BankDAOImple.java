package com.wipro.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository("bankDao")
public class BankDAOImple implements BankDAO {
	@Autowired
	private JdbcTemplate jt;
	private static final String WITHDRAW_QRY ="update tx_account set amt=amt-? where accno=?";
	private static final String DEPOSIT_QRY = "update tx_account set amt=amt+? where accno=?";


	@Override
	public int withdraw(int acno, int amt) {
		// TODO Auto-generated method stub
		int cnt = jt.update(WITHDRAW_QRY, amt, acno);
		return cnt;
	}

	@Override
	public int deposit(int acno, int amt) {
		// TODO Auto-generated method stub
		int cnt = jt.update(DEPOSIT_QRY, amt, acno);
		return cnt;
	}

}
