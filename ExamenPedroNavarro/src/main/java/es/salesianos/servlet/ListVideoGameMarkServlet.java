package es.salesianos.servlet;

import java.io.IOException;


import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.service.VideoGameService;

import es.salesianos.model.Console;
import es.salesianos.model.VideoGame;

public class ListVideoGameMarkServlet extends HttpServlet {

	private VideoGameService service = new VideoGameService();
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<VideoGame> listAllVideoGames = service.listAllVideoGames();
		request.setAttribute("listAllVideoGames", listAllVideoGames);
		redirect(request,response);
	}
	
	protected void redirect(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/VideoGameList.jsp");
		dispatcher.forward(request,response);
	}
}
