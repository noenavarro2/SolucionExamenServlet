package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.VideoGame;


public class VideoGameAssembler {
	
	public static VideoGame assembleObjectFrom(HttpServletRequest request) {
		VideoGame videogame = new VideoGame();
		videogame.setTitle(request.getParameter("title"));
		videogame.setRecommendedAge(request.getParameter("recommendedAge"));
		videogame.setLaunchDate(request.getParameter("launchDate"));
		videogame.setCompany(Integer.parseInt(request.getParameter("console")));
		return videogame;
	}
}
