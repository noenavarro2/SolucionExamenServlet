package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.VideoGame;


public class VideoGameAssembler {
	static VideoGame videoGame = new VideoGame();
	
	public static VideoGame assembleObjectFrom(HttpServletRequest request) {
		String title = request.getParameter("title");
		String launchDate = request.getParameter("launchDate");
		String recommendedAge= request.getParameter("recommendedAge");
		videoGame.setTitle(title);
		videoGame.setRecommendedAge(recommendedAge);
		videoGame.setLaunchDate(launchDate);
		return videoGame;
	}
}
