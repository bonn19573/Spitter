package com.guorui.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String showRegistrationForm(){
		return "registrationForm";
	}
}
