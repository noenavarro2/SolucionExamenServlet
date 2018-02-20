package es.salesianos.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import es.salesianos.assembler.VideoGameAssembler;
import es.salesianos.model.Company;
import es.salesianos.model.Console;
import es.salesianos.model.VideoGame;
import es.salesianos.repository.VideoGameRepository;


public class VideogameService implements Service<VideoGame> {
	
	private VideoGameRepository repository = new VideoGameRepository();

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
		
	public List<VideoGame> listByCompany(Company company) {
			return repository.searchByCompany(company);
	}
	public List<VideoGame> OrderLaunchDate() {
		return  repository.orderByLaunchDate();
	}
	
	public VideoGameRepository getRepository() {
		return repository;
	}
	
	public void setRepository(VideoGameRepository repository) {
		this.repository = repository;
	}
	
	public void createNewVideoGameFromRequest(VideoGame VideoGame) {
		repository.insert(VideoGame);
}

	
	
}
