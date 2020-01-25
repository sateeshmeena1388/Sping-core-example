package com.wipro.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.wpro.domain.EmployeeHLO;

@Configuration
@ComponentScan(basePackages = "com.wipro.dao")
public class PersistanceConfig {
	
	@Autowired
	private DataSource ds;
	
	@Bean("localSesFact")
	public LocalSessionFactoryBean createLocalSessionFactoryBean() {
		LocalSessionFactoryBean bean = null;

		bean = new LocalSessionFactoryBean();
		bean.setAnnotatedClasses(EmployeeHLO.class);
		bean.setDataSource(ds);
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
