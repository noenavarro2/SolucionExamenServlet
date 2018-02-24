package es.salesianos.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import es.salesianos.model.Company;
import es.salesianos.model.VideoGame;
import es.salesianos.service.VideogameService;

@Controller
public class VideogameController {

	private static Logger log = LogManager.getLogger(CompanyController.class);

	@Autowired
	private VideogameService service;

	@PostMapping("/VideogameRegister")
	public ModelAndView saveVideogame(@ModelAttribute VideoGame videogame) {
		log.debug("register videogame post ");
		service.insert(videogame);
		return new ModelAndView("VideogameRegister", "command", new VideoGame());
	}

	@GetMapping("/VideoGameList")
	public ModelAndView listVideogame() {
		log.debug("list videogame get ");
		ModelAndView modelAndView = new ModelAndView("VideoGameList", "command", new VideoGame());
		modelAndView.addObject("listAllVideogames", service.listAll());
		return modelAndView;
	}

	@PostMapping("/VideogameCompanyList")
	public ModelAndView listVideogamesCompany(@ModelAttribute Company company) {
		log.debug("list videogame by company post ");
		ModelAndView modelAndView = new ModelAndView("VideogameCompanyList", "command", new VideoGame());
		modelAndView.addObject("listAllVideogames", service.listByCompany(company));
		return modelAndView;
	}

	@GetMapping("/RecommendedAgeList")
	public ModelAndView listRecommendedAge() {
		log.debug("list By recommended Age get ");
		ModelAndView modelAndView = new ModelAndView("RecommendedAgeList");
		modelAndView.addObject("age");
		return modelAndView;
	}

	@PostMapping("/listRecommendedAge")
	public ModelAndView listRecommendedAge(@ModelAttribute VideoGame recommendedAge) {
		log.debug("recommended Age post ");
		ModelAndView modelAndView = new ModelAndView("listRecommendedAge", "command", new VideoGame());
		modelAndView.addObject("listAllVideogames", service.listByRecommendedAge(recommendedAge));
		return modelAndView;
	}
}
