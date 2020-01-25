package com.wipro.service;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.dao.BankDAO;
@Service("bankService")
public class BankServiceImple implements BankService {
	@Autowired
private BankDAO dao;
@Transactional(propagation=Propagation.REQUIRED,readOnly=false
,transactionManager="dstxMgr",timeout=30
)
	@Override
	public boolean transferMoney(int srcNo, int desNO, int amt) {
		// TODO Auto-generated method stub
		int result1=dao.withdraw(srcNo, amt);
		int result2=dao.deposit(desNO, amt);
		if(result1==0|| result2==0)
			throw new RuntimeException("Money not Transfer(Tx RollBack");
		else
			System.out.println("Money Transfer(Tx Commited)");
		return true;
	}

}
