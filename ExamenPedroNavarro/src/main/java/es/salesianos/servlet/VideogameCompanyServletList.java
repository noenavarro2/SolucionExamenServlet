package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Company;
import es.salesianos.model.VideoGame;
import es.salesianos.service.CompanyService;
import es.salesianos.service.VideogameService;

public class VideogameCompanyServletList extends HttpServlet {

	private CompanyService service = new CompanyService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		List<Company> listAllCompany = service.listAll();
		request.setAttribute("listAllCompany", listAllCompany);
		redirect(request,resp);
	}
	
	protected void redirect(HttpServletRequest request, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListVideoGameCompany.jsp");
		dispatcher.forward(request,resp);
	}

}
