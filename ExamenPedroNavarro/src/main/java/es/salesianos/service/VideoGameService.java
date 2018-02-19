package es.salesianos.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import es.salesianos.assembler.VideoGameAssembler;
import es.salesianos.model.Console;
import es.salesianos.model.VideoGame;
import es.salesianos.repository.VideoGamesRepository;


public class VideogameService implements Service<VideoGame> {
	
	private VideoGamesRepository repository = new VideoGamesRepository();

	@Override
	public VideoGame createObjectFromRequest(HttpServletRequest request) {
		VideoGame videogame = VideoGameAssembler.assembleObjectFrom(request);
		return videogame;
	}

	@Override
	public void insert(VideoGame videogame) {
		repository.insert(videogame);
	}

	@Override
	public void delete(VideoGame videogame) {
		repository.delete(videogame);
	}

	@Override
	public List<VideoGame> listAll() {
		return repository.listAll();
	}
	
	public List<VideoGame> listByRecommendedAge(String recommendedAge) {
			return repository.searchByRecommendedAge(recommendedAge);
	}
		
	public List<VideoGame> listByConsole(Console console) {
			return repository.searchByConsole(console);
	}
	
}
