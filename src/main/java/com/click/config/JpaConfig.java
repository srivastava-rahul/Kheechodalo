package com.click.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan({ "com.click.entity", "com.click.core.enums" })
@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties" })
public class JpaConfig {

	@Autowired
	private Environment env;

	@Bean(name = "transactionManager")
	public JpaTransactionManager jpaTransMan() {
		JpaTransactionManager jtm = new JpaTransactionManager(getEntityManagerFactoryBean().getObject());
		return jtm;
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setBeanName("entityManagerFactory");
		factoryBean.setDataSource(getDataSource());
		factoryBean.setPersistenceUnitName("persistenceUnit");
		factoryBean.setJpaVendorAdapter(getJpaVendor());
		factoryBean.setPackagesToScan("com.click.entity");
		Properties jpaProperties = new Properties();
		// jpaProperties.setProperty("hibernate.globally_quoted_identifiers",
		// "true");
		jpaProperties.setProperty("hibernate.show_sql", "false");
		jpaProperties.setProperty("hibernate.format_sql", "true");
		// jpaProperties.setProperty("hibernate.generate_statistics", "true");
		jpaProperties.setProperty("hibernate.hibernate.hbm2ddl.auto", "update");
		jpaProperties.setProperty("hibernate.default_schema", env.getRequiredProperty("db.schema"));
		// jpaProperties.setProperty("hibernate.event.merge.entity_copy_observer",
		// "allow");
		factoryBean.setJpaProperties(jpaProperties);
		LoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
		factoryBean.setLoadTimeWeaver(loadTimeWeaver);
		return factoryBean;
	}

	@Bean
	public HibernateJpaVendorAdapter getJpaVendor() {
		HibernateJpaVendorAdapter jpa = new HibernateJpaVendorAdapter();
		jpa.setDatabase(Database.valueOf(env.getRequiredProperty("db.jpa.type")));
		jpa.setShowSql(false);
		jpa.setGenerateDdl(Boolean.parseBoolean(env.getRequiredProperty("db.mode")));
		jpa.setDatabasePlatform(env.getRequiredProperty("db.dialect"));
		return jpa;
	}

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(env.getRequiredProperty("db.driver"));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		dataSource.setJdbcUrl(env.getRequiredProperty("db.url"));
		dataSource.setUser(env.getRequiredProperty("db.username"));
		dataSource.setPassword(env.getRequiredProperty("db.password"));
		dataSource.setInitialPoolSize(5);
		dataSource.setMinPoolSize(5);
		dataSource.setMaxPoolSize(150);
		dataSource.setMaxIdleTime(3600);
		dataSource.setAcquireIncrement(5);
		dataSource.setIdleConnectionTestPeriod(300);
		dataSource.setMaxStatements(4);
		dataSource.setPreferredTestQuery("select 1");
		dataSource.setCheckoutTimeout(Integer.parseInt(env.getRequiredProperty("db.connection.timeout")));
		return dataSource;
	}

}
