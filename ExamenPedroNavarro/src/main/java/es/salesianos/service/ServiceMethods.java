package es.salesianos.service;

import java.util.List;

public interface ServiceMethods<T> {
	
	public void insert(T t);
	
	public void delete(T t);

	public List<T> listAll();
}
