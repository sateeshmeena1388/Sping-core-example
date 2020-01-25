package com.mhb.adaptor;

import java.sql.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class SQLDateAdapter extends XmlAdapter<String, Date> {

	@Override
	public String marshal(Date d) throws Exception {
		// TODO Auto-generated method stub
		return d.toString();
	}

	@Override
	public Date unmarshal(String d) throws Exception {
		// TODO Auto-generated method stub
		return java.sql.Date.valueOf(d);
	}

}
