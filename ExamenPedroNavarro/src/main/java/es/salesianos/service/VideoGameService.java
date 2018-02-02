package es.salesianos.service;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.VideoGameAssembler;
import es.salesianos.model.VideoGame;
import es.salesianos.repository.VideoGamesRepository;

public class VideoGameService implements Service{
	
	private VideoGamesRepository repository = new VideoGamesRepository();

	@Override
	public void createObjectFromRequest(HttpServletRequest request) {
	}
	
	public VideoGame assembleVideojuegoFromRequest(HttpServletRequest request) {
		return VideoGameAssembler.assembleObjectFrom(request);
	}

	public void insertOrUpdate(VideoGame videoGameForm) {
		VideoGame videoGameInDatabase = repository.search(videoGameForm);
		if(null == videoGameInDatabase){
			repository.insert(videoGameForm);
		}else{
			repository.update(videoGameForm);
		}
	}
	
	public VideoGame findVideoGame(VideoGame videoGameForm) {
		return repository.search(videoGameForm);
	}
	
	public void delete(VideoGame videoGameForm) {
		repository.delete(videoGameForm);
	}
	
	public List<VideoGame> listAllVideoGames() {
		return repository.searchAll();
	}

	


}
