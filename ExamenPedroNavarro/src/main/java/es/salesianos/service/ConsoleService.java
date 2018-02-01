package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.ConsoleAssembler;
import es.salesianos.model.Console;
import es.salesianos.model.Company;
import es.salesianos.model.VideoGame;
import es.salesianos.repository.ConsolesRepository;
import es.salesianos.repository.CompaniesRepository;

public class ConsoleService implements Service{
	
	private ConsolesRepository repository = new ConsolesRepository();

	public void createObjectFromRequest(HttpServletRequest req) {
		throw new RuntimeException("Error");		
	}
	
	public Console assembleConsolaFromRequest(HttpServletRequest req) {
		return ConsoleAssembler.assembleObjectFrom(req);
	}
	
	public void insertOrUpdate(Console consolaFormulario) {
		Console consolaInDatabase = repository.search(consolaFormulario);
		if(null == consolaInDatabase){
			repository.insert(consolaFormulario);
		}else{
			repository.update(consolaFormulario);
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
	
	/*public void insertOrUpdate(String consolaFormulario) {
		Empresa empresa = repository1.myEmpresa(consolaFormulario);
		Consola consolaInDatabase = repository
		Consola consolaInDatabase = repository.search(consolaFormulario);
		if(null == consolaInDatabase){
			repository.insert(consolaFormulario);
		}else{
			repository.update(consolaFormulario);
		}
	}*/

}
