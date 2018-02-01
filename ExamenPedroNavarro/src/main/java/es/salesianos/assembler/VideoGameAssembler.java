package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.VideoGame;


public class VideoGameAssembler {

	public static VideoGame assembleObjectFrom(HttpServletRequest req) {
		VideoGame videoGame = new VideoGame();
		String title = req.getParameter("title");
		String launchDate = req.getParameter("recommendedAge");
		String recommendedAge= req.getParameter("launchDate");
		videoGame.setTitle(title);
		videoGame.setRecommendedAge(recommendedAge);
		videoGame.setLaunchDate(launchDate);
		return videoGame;
	
	}

}
