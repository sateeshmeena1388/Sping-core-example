package com.wipro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.dao.BankDAO;
@Service("bankService")
public class BankServiceImpl implements BankService {
	@Autowired
private BankDAO dao;

@Transactional(propagation=Propagation.REQUIRED,readOnly=false,transactionManager="dsTxMgmr",timeout=30)
	@Override
	public boolean transferMoney(int srcNO, int destNo, float amount) {
		// TODO Auto-generated method stub
		int result1=0,result2=0;
		boolean flag=false;
		result1=dao.withdraw(srcNO, amount);
		result2=dao.deposite(destNo, amount);
		if(result1==0|| result2==0){
			throw new IllegalArgumentException("Invalid Data");
		
		}
		else
		{
		flag= true;
		}
		return flag;
	}

}
