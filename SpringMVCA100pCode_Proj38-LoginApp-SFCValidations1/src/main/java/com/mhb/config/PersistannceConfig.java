package com.mhb.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages="com.mhb.dao")
public class PersistannceConfig {

	@Bean
	public DataSource createDataSource(){
		BasicDataSource bds=null;
		bds=new BasicDataSource();
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("scott");
		bds.setPassword("tiger");
		return bds;
		
	
	}
	@Bean
	public JdbcTemplate createJdbcTemplate(){
	return new JdbcTemplate(createDataSource());
	}
}
