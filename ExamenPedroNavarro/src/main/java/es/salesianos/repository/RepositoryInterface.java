package es.salesianos.repository;

import java.util.List;

public interface RepositoryInterface<T> {
	
	public static final String JDBCURL = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	public void insert(T t);
	public void delete(T t);
	public List<T> listAll();
}

