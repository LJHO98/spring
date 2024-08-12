package com.movieAndgame.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.GameMember;

@Controller
@RequestMapping("/game")
public class GameController {
	@GetMapping("/index")
	public String gameHome(Model model) {
		return "game/index";
	}
	@GetMapping("/login")
	public String loginHome(Model model) {
		model.addAttribute("member", new GameMember());
		return "game/member/login";
	}
	@GetMapping("/signUp")
	public String signUp() {
		return "game/member/signUp";
	}
}
