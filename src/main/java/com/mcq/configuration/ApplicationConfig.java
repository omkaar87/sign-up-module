package com.mcq.configuration;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Spring configuration for sample application.
 */
@Configuration
@EnableTransactionManagement
public class ApplicationConfig {

	@Value("${db.driver}")
	  private String DB_DRIVER;
	  
	  @Value("${db.password}")
	  private String DB_PASSWORD;
	  
	  @Value("${db.url}")
	  private String DB_URL;
	  
	  @Value("${db.username}")
	  private String DB_USERNAME;
	  
	  @Value("${db.initial_pool}")
	  private int INITIAL_POOL_SIZE;
	  
	  @Value("${db.min_pool}")
	  private int MIN_POOL;

	  @Value("${db.max_pool}")
	  private int MAX_POOL;
	  
	  @Value("${db.idle_time}")
	  private int IDLE_TIME;
	  
	  @Value("${hibernate.dialect}")
	  private String HIBERNATE_DIALECT;
	  
	  @Value("${hibernate.show_sql}")
	  private String HIBERNATE_SHOW_SQL;
	  
	 /* @Value("${hibernate.hbm2ddl.auto}")
	  private String HIBERNATE_HBM2DDL_AUTO;*/

	  @Value("${entitymanager.packagesToScan}")
	  private String ENTITYMANAGER_PACKAGES_TO_SCAN;
	  
	  @Bean
	  public DataSource myDataSource() throws PropertyVetoException
	  {
		  ComboPooledDataSource dataSource = new ComboPooledDataSource();
		  dataSource.setDriverClass(DB_DRIVER);
		  dataSource.setJdbcUrl(DB_URL);
		  dataSource.setUser(DB_USERNAME);
		  dataSource.setPassword(DB_PASSWORD);
		  
		  dataSource.setInitialPoolSize(INITIAL_POOL_SIZE);
		  dataSource.setMinPoolSize(MIN_POOL);
		  dataSource.setMaxPoolSize(MAX_POOL);
		  dataSource.setMaxIdleTime(IDLE_TIME);
		  
		  return dataSource;
		  
	  }
	  
	  /*@Bean
	  public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(DB_DRIVER);
	    dataSource.setUrl(DB_URL);
	    dataSource.setUsername(DB_USERNAME);
	    dataSource.setPassword(DB_PASSWORD);
	    return dataSource;
	  }*/

	  @Bean
	  public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException {
	    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
	    sessionFactoryBean.setDataSource(myDataSource());
	    sessionFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
	    Properties hibernateProperties = new Properties();
	    hibernateProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
	    hibernateProperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
	    //hibernateProperties.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
	    sessionFactoryBean.setHibernateProperties(hibernateProperties);
	    
	    return sessionFactoryBean;
	  }
	  
	  /*@Bean
	  public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws PropertyVetoException {
	        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	        em.setDataSource(myDataSource());
	        em.setPackagesToScan("com.mcq.repository");

	        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	        em.setJpaVendorAdapter(vendorAdapter);

	        return em;
	  }*/

	  @Bean
	  public HibernateTransactionManager transactionManager() throws PropertyVetoException {
	    HibernateTransactionManager transactionManager = 
	        new HibernateTransactionManager();
	    transactionManager.setSessionFactory(sessionFactory().getObject());
	    return transactionManager;
	  }
    

}
