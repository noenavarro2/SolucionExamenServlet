package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.salesianos.service.ConsoleService;
import es.salesianos.model.Console;


public class ListConsolesMarkServlet extends HttpServlet {

	private ConsoleService service = new ConsoleService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Console> listAllConsoles = service.listAll();
		request.setAttribute("listAllConsoles", listAllConsoles);
		redirect(request,response);
	}
	
	protected void redirect(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ConsoleList.jsp");
		dispatcher.forward(request,response);
	}
}
