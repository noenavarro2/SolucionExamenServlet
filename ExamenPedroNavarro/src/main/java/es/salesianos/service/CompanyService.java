package es.salesianos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.salesianos.model.Company;
import es.salesianos.repository.CompanyRepository;


@Service
public class CompanyService implements ServiceMethods<Company> {
	
	@Autowired
	private CompanyRepository repository;
	
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
