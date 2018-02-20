package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.*;
import es.salesianos.model.*;
import es.salesianos.repository.*;

public class CompanyService implements Service<Company> {
	
	private CompanyRepository repository = new CompanyRepository();
	
	public void createNewCompanyFromRequest(Company company) {
		repository.insert(company);
}
	@Override
	public Company createObjectFromRequest(HttpServletRequest request) {
		Company company = CompanyAssembler.assembleObjectFrom(request);
		return company;
	}
	
	@Override
	public void insert(Company company) {
		repository.insert(company);
	}
	
	@Override
	public void delete(Company company) {
		repository.delete(company);
	}
	
	@Override
	public List<Company> listAll() {
		return repository.listAll();
	}
	
	public CompanyRepository getRepository() {
		return repository;
	}
	
	public void setRepository(CompanyRepository repository) {
		this.repository = repository;
	}
}
