package com.wipro.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.wpro.domain.EmployeeHLO;

@Configuration
@ComponentScan(basePackages = "com.wipro.dao")
public class PersistanceConfig {
	
	
	@Bean("dbcpds")
	public DataSource createDataSource() {

		BasicDataSource cpds = null;
		cpds = new BasicDataSource();
		cpds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		cpds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		cpds.setUsername("scott");
		cpds.setPassword("tiger");
		return cpds;
	}

	@Bean("localSesFact")
	public LocalSessionFactoryBean createLocalSessionFactoryBean() {
		LocalSessionFactoryBean bean = null;

		bean = new LocalSessionFactoryBean();
		bean.setAnnotatedClasses(EmployeeHLO.class);
		bean.setDataSource(createDataSource());
		Properties props = null;
		props = new Properties();
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.format_sql", "true");
		props.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		bean.setHibernateProperties(props);
		return bean;
	}

	@Bean("sesFact")
	public SessionFactory createSessionFactory() {
		return createLocalSessionFactoryBean().getObject();

	}

	@Bean("ht")
	public HibernateTemplate createHibernateTemplate() {
		return new HibernateTemplate(createSessionFactory());
	}

}
