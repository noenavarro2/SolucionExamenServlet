package es.salesianos.servlet;

import java.io.IOException;



import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.service.ConsoleService;
import es.salesianos.model.Console;
import es.salesianos.model.VideoGame;
import es.salesianos.repository.ConsolesRepository;

public class ListConsolasMarcasServlet extends HttpServlet {

	private ConsoleService service = new ConsoleService();


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Console> listAllConsoles = service.listAllConsoles();
		req.setAttribute("listAllConsoles", listAllConsoles);
		redirect(req,resp);
	}
	
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ConsoleList.jsp");
		dispatcher.forward(req,resp);
}
}
