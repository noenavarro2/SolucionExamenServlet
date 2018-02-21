package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.service.VideogameService;
import es.salesianos.model.Console;
import es.salesianos.model.VideoGame;

public class VideoGameMarkServletList extends HttpServlet {

	private VideogameService service = new VideogameService();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<VideoGame> listAllVideoGame = service.listAll();
		request.setAttribute("listAllVideoGame", listAllVideoGame);
		redirect(request,response);
	}
	
	protected void redirect(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/VideoGameList.jsp");
		dispatcher.forward(request,response);
	}
}
