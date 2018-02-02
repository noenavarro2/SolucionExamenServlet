package es.salesianos.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.salesianos.service.ConsoleService;


public class ListConsolesServlet extends HttpServlet {

	private ConsoleService service = new ConsoleService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		service.createObjectFromRequest(request);
		redirect(request, response);
	}

	protected void redirect(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ConsoleList.jsp");
		dispatcher.forward(request, response);
	}

	public ConsoleService getService() {
		return service;
	}

	public void setService(ConsoleService service) {
		this.service = service;
	}
}
