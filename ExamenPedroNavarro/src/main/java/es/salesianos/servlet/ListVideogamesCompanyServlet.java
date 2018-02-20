package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Company;
import es.salesianos.model.VideoGame;
import es.salesianos.service.VideogameService;

public class ListVideogamesCompanyServlet extends HttpServlet {

	private VideogameService service = new VideogameService();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<VideoGame> listAllVideogames = service.listAll();
		req.setAttribute("listAllVideogames", listAllVideogames);
		redirect(req,resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listVideogamesCompany.jsp");
		dispatcher.forward(req,resp);
	}
	
	public VideogameService getService() {
		return service;
	}

	public void setService(VideogameService service) {
		this.service = service;
	}

}
