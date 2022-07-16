package com.juanbayon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/")
@Log4j2
public class MilestonesController {
	
	@GetMapping
	public String showResume(Model model) {
		
		log.trace("showResume");
		model.addAttribute("actual", "resume");
		return "index";
	}
	
	@GetMapping("contact")
	public String showContact(Model model) {
		
		log.info("showContact");
		model.addAttribute("actual", "contact");
		return "contact";
		
	}
	
	@GetMapping("/portfolio")
	public String showPorfolio(Model model) {
		
		log.info("showPortfolio");
		model.addAttribute("actual", "portfolio");
		return "portfolio";
		
	}

}
