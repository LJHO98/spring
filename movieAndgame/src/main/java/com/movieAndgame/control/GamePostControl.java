package com.movieAndgame.control;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.GameMember;
import com.movieAndgame.Dto.GamePostDto;
import com.movieAndgame.service.GamePostService;

@Controller
@RequestMapping("/gamePost")
public class GamePostControl {
	
	@Autowired
	private GamePostService postService;
	
	@GetMapping("/m")
	public String PostMain(Model model) {
		return "game/post/mobile";
	}
	
	@GetMapping("/tacticWrite")
	public String tacticWrite(Model model, HttpSession session) {
		if(session.getAttribute("user")==null) {
			return "redirect:/game/login";
		}
		GamePostDto dto = new GamePostDto();
		String name = ((GameMember)session.getAttribute("user")).getName();
		dto.setWriter(name);
		
		model.addAttribute("gamePostDto", dto);
		
		return "game/post/write";
		
	}
	
	@GetMapping("/write")
	public String write(@Valid GamePostDto gamePostDto, BindingResult binding, Model model) {
		if(binding.hasErrors()) {
			return "game/post/write";
		}
		postService.postSave(gamePostDto);
		return "redirect:/gamePost/m";
	
	}
	
	
}
