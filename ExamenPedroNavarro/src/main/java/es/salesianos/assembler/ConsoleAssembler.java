package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.Company;
import es.salesianos.model.Console;
import es.salesianos.repository.CompanysRepository;

public class ConsoleAssembler {
	static CompanysRepository repository = new CompanysRepository();

	public static Console assembleObjectFrom(HttpServletRequest request) {
		Console console = new Console();
		String name = request.getParameter("name");
		String companyName = request.getParameter("company");
		console.setName(name);
		Company primaryCompany = repository.myCompany(companyName);
		console.setCompany(primaryCompany);
		return console;
	}
}
