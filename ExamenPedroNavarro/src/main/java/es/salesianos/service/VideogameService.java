package es.salesianos.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.salesianos.model.Company;
import es.salesianos.model.VideoGame;
import es.salesianos.repository.VideoGameRepository;

@Service
public class VideogameService implements ServiceMethods<VideoGame> {
	
	@Autowired
	private VideoGameRepository repository;

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
	
	public Optional<VideoGame> listByRecommendedAge(VideoGame recommendedAge) {
			return repository.searchByRecommendedAge(recommendedAge);
	}
		
	public Optional<Company> listByCompany(Company company) {
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
