package es.salesianos.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.salesianos.model.*;
import es.salesianos.service.CompanyService;

public class companyRegister extends HttpServlet{
	
	private CompanyService service = new CompanyService();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		Company company = service.createObjectFromRequest(request);
		service.createNewCompanyFromRequest(company);
		redirect(request,resp);
	}
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CompanyRegister.jsp");
		dispatcher.forward(req, resp);
	}
}
