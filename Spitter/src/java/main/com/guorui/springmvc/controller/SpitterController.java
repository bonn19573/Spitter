package com.guorui.springmvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guorui.springmvc.dao.SpitterRepository;
import com.guorui.springmvc.entity.Spitter;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	private SpitterRepository spitterRepository;

	@Autowired
	public SpitterController(SpitterRepository spitterRepository) {
		this.spitterRepository = spitterRepository;

	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String showRegistrationForm() {
		return "registrationForm";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String saveSpitter(@Valid Spitter spitter, Errors errors) {
		if(errors.hasErrors()){
			return "registrationForm";
		}
		spitterRepository.save(spitter);

		return "redirect:/spitter/" + spitter.getUsername();
	}
	
	
	@RequestMapping(value = "/{username}" , method = RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String username, Model model){
		
		model.addAttribute(spitterRepository.findByName(username));
		
		return "profile";
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showAllSpitterList(Model model){
		model.addAttribute(spitterRepository.findAll());
		return "spitters";
	}
}
