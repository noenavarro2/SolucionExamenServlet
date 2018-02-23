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
import es.salesianos.model.Console;
import es.salesianos.service.CompanyService;

@Controller
public class CompanyController {
	
	private static Logger log = LogManager.getLogger(CompanyController.class);
	
	@Autowired
	private CompanyService service;
	
	@GetMapping("/CompanyRegister")
	public ModelAndView company() {
		log.debug("register company ");
		return new ModelAndView("CompanyRegister", "command", new Company());
	}
	
	@PostMapping("/CompanyRegister")
	public ModelAndView saveCompany(@ModelAttribute("company") Company company) {
		log.debug("post new company");
		service.insert(company);
		return new ModelAndView("CompanyRegister", "command", new Company());
	}
	
	@GetMapping("/ConsoleRegister")
	public ModelAndView console() {
		log.debug(" get new console");
		ModelAndView modelAndView = new ModelAndView("ConsoleRegister", "command", new Console());
		modelAndView.addObject("listAllCompanies", service.listAll());
		return modelAndView;
	}
	
	@GetMapping("/ConsoleByComoanyList")
	public ModelAndView listConsolesCompany() {
		log.debug(" list consoles");
		ModelAndView modelAndView = new ModelAndView("ConsoleByComoanyList", "command", new Console());
		modelAndView.addObject("listAllCompanies", service.listAll());
		return modelAndView;
	}
	
	@GetMapping("/videogameCompanyList")
	public ModelAndView listVideogamesCompany() {
		log.debug(" list videogames and company");
		ModelAndView modelAndView = new ModelAndView("videogameCompanyList", "command", new Company());
		modelAndView.addObject("listAllCompanies", service.listAll());
		return modelAndView;
	}

}
