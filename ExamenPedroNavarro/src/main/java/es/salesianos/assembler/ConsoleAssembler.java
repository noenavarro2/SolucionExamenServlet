package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.Company;
import es.salesianos.model.Console;
import es.salesianos.repository.CompaniesRepository;

public class ConsoleAssembler {

	
	public static Console assembleObjectFrom(HttpServletRequest req) {
		CompaniesRepository repo = new CompaniesRepository();
		Console console = new Console();
		String name = req.getParameter("name");
		String companyName = req.getParameter("company");
		console.setName(name);
		Company primaryCompany = repo.myEmpresa(companyName);
		console.setCompany(primaryCompany);
		return console;
	}

}
