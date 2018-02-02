package es.salesianos.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.salesianos.service.VideoGameService;

public class ListVideoGamesServlet extends HttpServlet {

	VideoGameService service = new VideoGameService();

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
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/VideoGameList.jsp");
		dispatcher.forward(request, response);
	}

	public VideoGameService getService() {
		return service;
	}

	public void setService(VideoGameService service) {
		this.service = service;
	}
}
