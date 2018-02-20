package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.Company;
import es.salesianos.model.Console;
import es.salesianos.repository.CompanyRepository;

public class ConsoleAssembler {

	public static Console assembleObjectFrom(HttpServletRequest request) {
		Console console = new Console();
		console.setName(request.getParameter("name"));
		console.setCompany(Integer.parseInt(request.getParameter("company")));
		return console;
	}
}
