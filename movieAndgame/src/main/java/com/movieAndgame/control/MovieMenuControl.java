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

import com.movieAndgame.Dto.MovieMember;
import com.movieAndgame.Dto.MovieReviewDto;
import com.movieAndgame.service.MovieReviewService;

@Controller
@RequestMapping("/movieMenu")
public class MovieMenuControl {
	
	@Autowired
	private MovieReviewService reviewService;
	
	//작성한 글 리스트
	@GetMapping("/review")
	public String reviewMain(Model model) {
		List<MovieReviewDto> list = reviewService.load();
		model.addAttribute("reviewList", list);
		return "movie/review/index";
	}
	
	// 리뷰작성페이지 요청
	@GetMapping("/reviewWrite")
	public String write(Model model, HttpSession session) {
		if(session.getAttribute("user")==null) { //로그인 상태가 아니면 로그인페이지 이동
			return "redirect:/movie/login";
		}
		MovieReviewDto dto = new MovieReviewDto();
		String name = ((MovieMember)session.getAttribute("user")).getName();
		dto.setWriter(name);
		
		model.addAttribute("movieReviewDto",dto);
		
		return "movie/review/write";
	}
	// 글 내용작성후 저장 요청
	@GetMapping("/write")
	public String reviewWrite(@Valid MovieReviewDto movieReviewDto, BindingResult bind, Model model) {
		
		if(bind.hasErrors()) { //form 데이터 값이 유요하지 않다면
			return "movie/review/write";
		}
		reviewService.save(movieReviewDto);
		return "redirect:/movieMenu/review";
	}
	
	@GetMapping("/view/{id}")
	public String view(@PathVariable("id") int id, Model model) {
		MovieReviewDto dto = reviewService.findById(id);
		model.addAttribute("movieReviewDto",dto);
		return "movie/review/detail";
	}

}
