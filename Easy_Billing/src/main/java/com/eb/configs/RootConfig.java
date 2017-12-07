package com.eb.configs;

import java.io.IOException;




import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.eb.bo.CompanyDetailsBo;
import com.eb.bo.CustomerDetailsBo;
import com.eb.bo.ProductBo;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages= {"com.eb.daos","com.eb.service","com.eb.util"})
public class RootConfig  {
	
	private Properties properties;
	
	
	
	
	public RootConfig() {
		
		loadDbCredentials();
		
	}
	
	
	public void loadDbCredentials() {
		properties=new Properties();
		try {
			properties.load(RootConfig.class.getClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
		throw new DataAccessResourceFailureException("FAILED TO LOAD DATABASE CREDENTIALS");
		}
	}
	
	@Bean(name="dataSource")
	public DriverManagerDataSource dataSource() {
		
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setUrl(properties.getProperty("db.url"));
		dataSource.setDriverClassName(properties.getProperty("db.driverClass"));
		dataSource.setUsername(properties.getProperty("db.userName"));
		dataSource.setPassword(properties.getProperty("db.password"));
	
		return dataSource;
	}

	@Bean(name="sessionFactory")
	public LocalSessionFactoryBean getSessionFactory() {
		
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setHibernateProperties(properties);
		sessionFactory.setAnnotatedClasses(ProductBo.class,CompanyDetailsBo.class,CustomerDetailsBo.class);
		return sessionFactory;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() {
		
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(getSessionFactory().getObject());
		
		return hibernateTransactionManager;
		
	}
	
	
	
	
	
	
}
