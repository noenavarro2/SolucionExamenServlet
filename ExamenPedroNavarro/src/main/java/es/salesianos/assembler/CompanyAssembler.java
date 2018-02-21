package es.salesianos.assembler;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Company;
import es.salesianos.model.Console;

public class CompanyAssembler {

	public static Company assembleObjectFrom(HttpServletRequest request) {
		Company company = new Company ();
		company.setName(request.getParameter("name"));
		company.setDate(Date.valueOf(request.getParameter("date")));
		return company;
	}
}
