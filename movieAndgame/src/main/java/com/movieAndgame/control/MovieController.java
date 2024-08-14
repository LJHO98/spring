package com.movieAndgame.control;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.MovieMember;
import com.movieAndgame.service.MovieMemberService;


@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieMemberService movieMemberService;
	
	
	// "/index"은 localhost/movie/index 매핑이다.
	@GetMapping("/index")
	public String movieHome(Model model) {
		return "movie/index";
	}
	
	@GetMapping("/login")
	public String loginHome(Model model) {
		model.addAttribute("member", new MovieMember());
		
		return "movie/member/login";
	}
	
	@GetMapping("/signUp")
	public String signUp(Model model) {
		model.addAttribute("movieMember", new MovieMember());
		return "movie/member/join";
	}
	
	@PostMapping("/signUp")
	public String submit(@Valid MovieMember movieMember, BindingResult bindResult, Model model) {
		if(bindResult.hasErrors()) {
			System.out.println("유효하지 않은 값 입력되었다.");
			return "movie/member/join";
		}
		movieMemberService.signUpSave(movieMember);
		
		
		return "redirect:/movie/login";
	}
}
