package com.example.bookTest.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.DTO.CoffeDto;
import com.example.bookTest.service.CoffeService;

@Controller
public class CoffeControl {
	
	@Autowired
	private CoffeService coffeService;
	
	@GetMapping("/coffe")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("coffe/index");
		List<CoffeDto> list = coffeService.selectAll();
		mv.addObject("list", list);
		return mv;
	}
	
	@GetMapping("/coffeReg")
	public String form() {
		return "coffe/coffeForm";
	}
	
	@PostMapping("/coffeWrite")
	public String write(@ModelAttribute CoffeDto coffeDto) {
		coffeService.coffeSave(coffeDto);
	
		return "redirect:coffe/index";
	}
}
