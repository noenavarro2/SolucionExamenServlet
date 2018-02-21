package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.salesianos.model.*;
import es.salesianos.service.VideogameService;

public class OrderByReleaseDateList extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private VideogameService service = new VideogameService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<VideoGame> listAllVideoGame = service.OrderLaunchDate();
		req.getSession().setAttribute("listAllVideoGame", listAllVideoGame);
		redirect(req,resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/VideoGameList.jsp");
		dispatcher.forward(req,resp);
	}
}

