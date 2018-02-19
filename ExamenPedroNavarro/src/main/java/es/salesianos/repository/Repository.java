package es.salesianos.repository;

import java.util.List;

import es.salesianos.connection.ConnectionH2;

public interface Repository<T> {
	
	public static final String JDBCURL = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	public static ConnectionH2 connection = new ConnectionH2();
	public void insert(T t);
	public void delete(T t);
	public List<T> listAll();
}

