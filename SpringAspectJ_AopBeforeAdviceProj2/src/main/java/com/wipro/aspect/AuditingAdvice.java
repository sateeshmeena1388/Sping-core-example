package com.wipro.aspect;

import java.io.FileWriter;
import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;

public class AuditingAdvice {
public void audit(JoinPoint jp,int oid) throws Throwable
{
	System.out.println("target method:"+jp.getSignature());
	System.out.println("target class:" +jp.getTarget().getClass());
	System.out.println("target method args"+Arrays.toString(jp.getArgs()));
	System.out.println("Order Id is"+oid);
	Object[] args=jp.getArgs();
	args[0]=(Integer)args[0]+1;
	jp.getArgs()[0]=args[0];
	//perform auditing
	FileWriter fw=new FileWriter("e:\\audit.log",true);
	fw.write("order with order id "+oid+"submited for approval on Date:"+new Date());
	fw.flush();
	fw.close();
}
}
