package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.h2.engine.Setting;

import es.salesianos.assembler.*;
import es.salesianos.model.*;
import es.salesianos.repository.*;

public class ConsoleService implements Service<Console> {

	private ConsoleRepository repository = new ConsoleRepository();

	@Override
	public Console createObjectFromRequest(HttpServletRequest request) {
		Console console = ConsoleAssembler.assembleObjectFrom(request);
		return console;
	}

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
	
	public List<Console> listAllByCompany(int company){
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
