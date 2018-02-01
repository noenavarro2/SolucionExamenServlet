package es.salesianos.service;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.VideoGameAssembler;
import es.salesianos.model.VideoGame;
import es.salesianos.repository.VideoGamesRepository;

public class VideoGameService implements Service{
	
	private VideoGamesRepository repository = new VideoGamesRepository();

	@Override
	public void createObjectFromRequest(HttpServletRequest req) {
		throw new RuntimeException("Esta petando");		
	}
	
	public VideoGame assembleVideojuegoFromRequest(HttpServletRequest req) {
		return VideoGameAssembler.assembleObjectFrom(req);
	}

	public void insertOrUpdate(VideoGame videojuegoFormulario) {
		VideoGame videojuegoInDatabase = repository.search(videojuegoFormulario);
		if(null == videojuegoInDatabase){
			repository.insert(videojuegoFormulario);
		}else{
			repository.update(videojuegoFormulario);
		}
	}
	
	public VideoGame findVideoGame(VideoGame videojuegoFormulario) {
		return repository.search(videojuegoFormulario);
	}
	
	public void delete(VideoGame videojuegoFormulario) {
		repository.delete(videojuegoFormulario);
	}
	
	public List<VideoGame> listAllVideoGames() {
		return repository.searchAll();
	}

	


}
