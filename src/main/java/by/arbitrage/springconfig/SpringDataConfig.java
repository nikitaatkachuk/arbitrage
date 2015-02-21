package by.arbitrage.springconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Created by Nikita Tkachuk
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("by.arbitrage.repository")
public class SpringDataConfig extends WebMvcConfigurerAdapter
{
	private static final String APP_JDBC_DRIVER_CLASS_NAME = "app.jdbc.driverClassName";
	private static final String APP_JDBC_URL = "app.jdbc.url";
	private static final String APP_JDBC_USERNAME = "app.jdbc.username";
	private static final String APP_JDBC_PASSWORD = "app.jdbc.password";

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		try {
			DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setDriverClassName(env.getRequiredProperty(APP_JDBC_DRIVER_CLASS_NAME));
			ds.setUrl(env.getRequiredProperty(APP_JDBC_URL));
			ds.setUsername(env.getRequiredProperty(APP_JDBC_USERNAME));
			ds.setPassword(env.getRequiredProperty(APP_JDBC_PASSWORD));
//			ds.setAcquireIncrement(5);
//			ds.setIdleConnectionTestPeriod(60);
//			ds.setMaxPoolSize(100);
//			ds.setMaxStatements(50);
//			ds.setMinPoolSize(10);
			return ds;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setPersistenceXmlLocation("classpath*:META-INF/persistence.xml");
		em.setPersistenceUnitName("hibernatePersistenceUnit");
		em.setDataSource(dataSource());
		HibernateJpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
		vendor.setShowSql(false);
		em.setJpaVendorAdapter(vendor);
		return em;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
}
