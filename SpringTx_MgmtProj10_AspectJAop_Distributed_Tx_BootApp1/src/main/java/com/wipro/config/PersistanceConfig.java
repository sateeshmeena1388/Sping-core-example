package com.wipro.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages="com.wipro.dao")
public class PersistanceConfig {
	@Bean(name="oraXADs")
	public DataSource createXADataSourceForOracle()
	{
		AtomikosDataSourceBean atmDs=null;
		Properties props=null;
		atmDs=new AtomikosDataSourceBean();
		atmDs.setUniqueResourceName("oraXA");
		atmDs.setXaDataSourceClassName("oracle.jdbc.xa.client.OracleXADataSource");
		props=new Properties();
		props.put("databaseName","xe");
		props.put("user","scott");
		props.put("password","tiger");
		props.put("URL","jdbc:oracle:thin:@localhost:1521:xe");
		atmDs.setXaProperties(props);
		atmDs.setPoolSize(10);
		return atmDs;
	}
	@Bean(name="mysqlXADs")
	public DataSource createXADataSourceForMySql()
	{
		AtomikosDataSourceBean atmDs=null;
		Properties props=null;
		atmDs=new AtomikosDataSourceBean();
		atmDs.setUniqueResourceName("mysqlXA");
		atmDs.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
		props=new Properties();
		props.put("databaseName", "exceyon");
		props.put("user","root");
		props.put("password","root");
		props.put("URL","jdbc:mysql:///exceyon");
		atmDs.setXaProperties(props);
		atmDs.setPoolSize(10);
		return atmDs;
	}
	@Bean(name="oraJt")
	public JdbcTemplate createJdbcTemplateForOracle()
	{
		return new JdbcTemplate(createXADataSourceForOracle());
	}
	@Bean(name="mysqlJt")
	public JdbcTemplate createJdbcTemplateForMysql()
	{
		return new JdbcTemplate(createXADataSourceForMySql());
	}

}
