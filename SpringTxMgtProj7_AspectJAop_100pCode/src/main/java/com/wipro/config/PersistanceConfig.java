package com.wipro.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages="com.wipro.dao")
public class PersistanceConfig {
	@Bean(name="dbcp")
public DataSource createDataSource(){
	BasicDataSource ds=null;
	ds=new BasicDataSource();
	ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	ds.setUsername("scott");
	ds.setPassword("tiger");
	ds.setInitialSize(10);
	ds.setMaxTotal(100);
	return ds;
}
@Bean(name="template")
public JdbcTemplate createJdbcTemplate()
{
	return new JdbcTemplate(createDataSource());
	
}
}
