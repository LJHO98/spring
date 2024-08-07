package com.example.bookTest.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.DTO.BookInfoDto;

@Controller
public class BookInfoController {
	@GetMapping("/write")
	public String inputPage() {
		return "bookWrite";
	}
	
	@GetMapping("/detail")
	public ModelAndView infoPage(@ModelAttribute BookInfoDto bookDto) {
		ModelAndView mv = new ModelAndView("bookDetail");
		mv.addObject("book", bookDto);
		return mv;
	}
}
