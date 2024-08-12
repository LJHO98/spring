package com.movieAndgame.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.movieAndgame.Dto.TestMember;

@Controller
public class TestController {
	@GetMapping("/test")
	public String test(Model model) {
		
		TestMember mem = new TestMember();
		mem.setAge(19);
		mem.setEmail("dfa@gmail.com");
		mem.setName("이순신");
		mem.setTel("010-4573-8292");
		
		String name = "이순신";
		
		List<String> animal = new ArrayList<>();
		animal.add("사자"); animal.add("개"); animal.add("고양이");
		animal.add("호랑이"); animal.add("코끼리");
		
		model.addAttribute("tag", "<h1>타임리프</h1>");
		model.addAttribute("name", name);
		model.addAttribute("member", mem);
		model.addAttribute("animal", animal);
		
		return "test";
	}
}
