package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.salesianos.model.VideoGame;
import es.salesianos.service.VideogameService;

public class ListVideoGamesServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	private VideogameService service = new VideogameService();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		List<VideoGame> listAllVideogames = service.listAll();
		request.setAttribute("listAllVideogames", listAllVideogames);
		redirect(request,resp);
	}
	
	protected void redirect(HttpServletRequest request, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listVideogame.jsp");
		dispatcher.forward(request,resp);
	}
	
	public VideogameService getService() {
		return service;
	}

	public void setService(VideogameService service) {
		this.service = service;
	}

}
