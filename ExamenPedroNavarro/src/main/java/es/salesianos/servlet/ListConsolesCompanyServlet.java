package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.salesianos.model.Console;
import es.salesianos.service.ConsoleService;


public class ListConsolesCompanyServlet extends HttpServlet {
	
	private ConsoleService service = new ConsoleService();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		List<Console> listAllConsoles = service.listAllByCompany();
		request.setAttribute("listAllConsoles", listAllConsoles);
		redirect(request,resp);
	}
	
	protected void redirect(HttpServletRequest request, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listConsolesCompany.jsp");
		dispatcher.forward(request,resp);
	}
	
	public ConsoleService getService() {
		return service;
	}

	public void setService(ConsoleService service) {
		this.service = service;
	}

}
