package com.example.test1.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class MainController {

// JSP MVC 패턴 주소 맵핑
//  주소패턴과 서블렛 클래스 연결 (web.xml)
//  주소패턴이 다양하면 서블렛클래스 갯수도 늘어난다.
//  주소 요청을 처리할 메서드 지정을 위해 Map, properties 같은 주소와 메서드를
//  1:1 지정하여 처리하기 위한 객체 또는 파일이 필요하다.
//  어떤 주소요청인지 파악하기 위한 코드와 실행 코드도 작성해야한다.
	
// 스프링에서의 주소 맵핑( 요청주소와 처리내용을 연결하는 작업 )
//	@Controller 클래스에 지정
//	요청방식에 따른 주소 맵핑 -> @GetMapping("/")
//	요청주소 처리할 메서드 정의 와 반환값으로 보여줄 페이지 이름
	@GetMapping("/test")
	public String testFirst() {
		return "test";
	}
	
	@GetMapping("/aaa.g")
	public String testTwo() {
		return "login";
	}
	
	@GetMapping("/signUp")
	public String signUp() {
		return "member/signUp";
	}
	
	@PostMapping("/signUp")
	public String signUpSave(@RequestParam("id") String id,
			@RequestParam("pw") String pw, @RequestParam("tel") String tel, @RequestParam("birth") String birth) {
		
		System.out.println(id);
		
		
		return "member/signUp";
	}

}
