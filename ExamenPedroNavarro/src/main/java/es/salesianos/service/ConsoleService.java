package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.ConsoleAssembler;
import es.salesianos.model.Console;
import es.salesianos.model.Company;
import es.salesianos.model.VideoGame;
import es.salesianos.repository.ConsolesRepository;
import es.salesianos.repository.CompanysRepository;

public class ConsoleService implements Service{
	
	private ConsolesRepository repository = new ConsolesRepository();

	public void createObjectFromRequest(HttpServletRequest request) {	
	}
	
	public Console assembleConsoleFromRequest(HttpServletRequest request) {
		return ConsoleAssembler.assembleObjectFrom(request);
	}
	
	public void insertOrUpdate(Console consoleForm) {
		Console consoleInDatabase = repository.search(consoleForm);
		if(null == consoleInDatabase){
			repository.insert(consoleForm);
		}else{
			repository.update(consoleForm);
		}
	}
	public Console findConsole(Console formConsole) {
		return repository.search(formConsole);
	}
	
	public void delete(Console formConsole) {
		repository.delete(formConsole);
	}
	
	public List<Console> listAllConsoles() {
		return repository.searchAll();
	}
	
}
