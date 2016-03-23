package com.guorui.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/helloworld")
public class HelloWorldController {
	
	
	@RequestMapping("/hello")
	public String sayHello(ModelMap model){
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return "hello";
	}

}
