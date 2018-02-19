package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Company;

public interface Service<T> {

	public T createObjectFromRequest(HttpServletRequest request);
	
	public void insert(T t);
	
	public void delete(T t);

	public List<T> listAll();


}
