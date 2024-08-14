package com.movieAndgame.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameMember {
	@NotBlank(message="이메일을 입력하세요")
	private String email;
	
	@Size(min=4, max=12, message="비밀번호는 4~12자리로 입력하세요")
	@Pattern(regexp="^[a-zA-z0-9]*$", message="영어 대소문자와 숫자만 입력하세요")
	private String password;
	
	@NotBlank(message="이름을 입력하세요")
	private String name;
}
