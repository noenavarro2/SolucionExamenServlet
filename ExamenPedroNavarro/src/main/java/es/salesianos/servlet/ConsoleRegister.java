package es.salesianos.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.salesianos.model.*;
import es.salesianos.service.ConsoleService;

public class ConsoleRegister extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private ConsoleService service = new ConsoleService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		Console console = service.createObjectFromRequest(request);
		service.createNewConsoleFromRequest(console);
		redirect(request,resp);
	}
	protected void redirect(HttpServletRequest request, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("ConsoleRegister.jsp");
		dispatcher.forward(request, resp);
	}
}
