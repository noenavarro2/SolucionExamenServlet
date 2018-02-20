package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.salesianos.model.*;
import es.salesianos.service.VideogameService;;


public class VideoGameRegister extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private VideogameService service = new VideogameService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		VideoGame videogame= service.createObjectFromRequest(request);
		service.createNewVideoGameFromRequest(videogame);
		redirect(request,resp);
	}
	
	protected void redirect(HttpServletRequest request, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/VideogameRegister.jsp");
		dispatcher.forward(request, resp);
	}
	
}
