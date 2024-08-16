package com.movieAndgame.control;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.GameMember;
import com.movieAndgame.service.GameMemberService;

@Controller
@RequestMapping("/game")
public class GameController {
	
	@Autowired
	GameMemberService gameMemberService;
	
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
	public String signUp(Model model) {
		model.addAttribute("gameMember", new GameMember());
		return "game/member/join";
	}
	
	@PostMapping("/signUp") //여기서의 gameMember는 join.html에 form태그에 th:object를 통해 지정한 gameMember이다.
	public String submit(@Valid GameMember gameMember, BindingResult bindResult, Model model) {
		if(bindResult.hasErrors()) {
			return "game/member/join";
		}
		gameMemberService.signUpSave(gameMember);
		return "redirect:/game/login";
	}
	
	@PostMapping("/signIn")
	public String signIn(GameMember member, HttpSession session, Model model) {
		GameMember user = gameMemberService.login(member);
		if(user==null) {
			model.addAttribute("member", member);
			model.addAttribute("fail", "f");
			return "game/member/login";
		}
		session.setAttribute("user", user);
		return "redirect:/game/index";
	}
}
