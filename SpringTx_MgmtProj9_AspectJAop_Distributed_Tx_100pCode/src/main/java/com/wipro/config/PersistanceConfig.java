package com.wipro.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.atomikos.jdbc.AtomikosDataSourceBean;
@Configuration
@ComponentScan(basePackages="com.wipro.dao")
public class PersistanceConfig {
	@Bean
	public  DataSource  createOraXADataSource(){
		AtomikosDataSourceBean  adsb=null;
		Properties props=null;
		
		adsb=new AtomikosDataSourceBean();
		adsb.setUniqueResourceName("XAOra");
		adsb.setXaDataSourceClassName("oracle.jdbc.xa.client.OracleXADataSource");
		props=new Properties();
		props.put("databaseName","xe");
		props.put("user","scott");
		props.put("password","tiger");
		props.put("URL","jdbc:oracle:thin:@localhost:1521:xe");
		adsb.setXaProperties(props);
		adsb.setPoolSize(10);
		return  adsb;
	}
	
	@Bean(name="oraTemplate")
	public  JdbcTemplate  createOracleJdbcTemplate(){
		return  new JdbcTemplate(createOraXADataSource());
	}
	
	@Bean
	public  DataSource  createMysqlXADataSource(){
		AtomikosDataSourceBean  adsb=null;
		Properties props=null;
		
		adsb=new AtomikosDataSourceBean();
		adsb.setUniqueResourceName("XAMysql");
		adsb.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");

		props=new Properties();
		props.put("databaseName","exceyon");
		props.put("user","root");
		props.put("password","root");
		props.put("URL","jdbc:mysql:///exceyon");
		adsb.setXaProperties(props);
		adsb.setPoolSize(10);
		return  adsb;
	}
	
	@Bean(name="mysqlTemplate")
	public  JdbcTemplate  createMysqlJdbcTemplate(){
		return  new JdbcTemplate(createMysqlXADataSource());
	}
}
