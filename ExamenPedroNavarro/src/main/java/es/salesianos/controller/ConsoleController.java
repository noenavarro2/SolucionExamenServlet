package es.salesianos.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import es.salesianos.model.Company;
import es.salesianos.model.Console;
import es.salesianos.model.VideoGame;
import es.salesianos.service.ConsoleService;

@Controller
public class ConsoleController {
	
	private static Logger log = LogManager.getLogger(CompanyController.class);
	
	@Autowired
	private ConsoleService service;	

	@PostMapping("/ConsoleRegister")
	public ModelAndView registerConsole(@ModelAttribute Console console) {
		log.debug("register console post ");
		service.insert(console);
		return new ModelAndView("ConsoleRegister", "command", new Console());
	}
	
	@GetMapping("/VideogameRegister")
	public ModelAndView videogame() {
		log.debug("register company ");
		ModelAndView modelAndView = new ModelAndView("VideogameRegister", "command", new VideoGame());
		modelAndView.addObject("listAllConsoles", service.listAll());
		return modelAndView;
	}
	
	@GetMapping("/ConsoleList")
	public ModelAndView listConsole() {
		log.debug("get list console ");
		ModelAndView modelAndView = new ModelAndView("ConsoleList", "command", new Console());
		modelAndView.addObject("listAllConsoles", service.listAll());
		return modelAndView;
	}

	@PostMapping("/ConsoleByCompanyList")
	public ModelAndView listConsolesCompany(@ModelAttribute Company company) {
		log.debug("list consoles company post ");
		ModelAndView modelAndView = new ModelAndView("ConsoleByCompanyList", "command", new Console());
		modelAndView.addObject("listAllConsoles", service.listAllByCompany(company.getName()));
		return modelAndView;
	}
}
