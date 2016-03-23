package com.guorui.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.guorui.springmvc.dao.SpittleRepository;
import com.guorui.springmvc.entity.Spittle;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

	private SpittleRepository spittleRepository;

	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}

	@RequestMapping(method = { RequestMethod.GET })
	public String spittles(Model model) {

		List<Spittle> spittles = spittleRepository.findSpittles(Long.MAX_VALUE, 20);
		model.addAttribute("spittleList", spittles);

		return "spittles";

	}

	@RequestMapping(method = { RequestMethod.GET })
	public List<Spittle> spittles(@RequestParam(value = "max") long max, @RequestParam("count") int count) {
		return spittleRepository.findSpittles(max, count);
	}

}
