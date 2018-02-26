package es.salesianos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.salesianos.model.Console;
import es.salesianos.repository.ConsoleRepository;

@Service
public class ConsoleService implements ServiceMethods<Console> {

	@Autowired
	private ConsoleRepository repository;

	@Override
	public void insert(Console console) {
		repository.insert(console);	
	}

	@Override
	public void delete(Console console) {
		repository.delete(console);
	}

	@Override
	public List<Console> listAll() {
		return repository.listAll();
	}
	
	public List<Console> listAllByCompany(String company){
		return repository.listAllByCompany(company);
	}
	
	public ConsoleRepository getRepository() {
		return repository;
	}
	
	public void setRepository(ConsoleRepository repository) {
		this.repository = repository;
	}
	
	public void createNewConsoleFromRequest(Console console) {
		repository.insert(console);
	}			
}
