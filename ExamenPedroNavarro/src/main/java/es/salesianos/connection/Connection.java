package es.salesianos.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class Connection {
	
	private static final String DRIVER = "org.h2.Driver";
	private static final String CONNECTION = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	
	@Autowired
	private DriverManagerDataSource dataSource;
	
	@Bean
	@Profile(value = "h2")
	public DriverManagerDataSource h2DataSource() {
		dataSource.setDriverClassName(DRIVER);
		dataSource.setUrl(CONNECTION);
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}
	
	@Bean
	@Profile(value = "postgres")
	public DriverManagerDataSource postgresDataSource() {
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgres:localhost:5432'");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}
}