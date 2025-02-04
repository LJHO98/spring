package com.movieAndgame.control;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		List<GamePostDto> list = postService.postList();
		model.addAttribute("tacticList", list);
		return "game/post/mobile";
	}
	
	@GetMapping("/tacticWrite")
	public String tacticWrite(Model model, HttpSession session) {
		if(session.getAttribute("user")==null) {
			session.setAttribute("writeFail", true);
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
	
	@GetMapping("/view/{id}")
	public String view(@PathVariable("id") int id, Model model) {
		GamePostDto dto = postService.findById(id);
		model.addAttribute("gamePost", dto);
		return "game/post/detail";
	}
	
	
}
