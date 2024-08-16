package com.movieAndgame.Dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GamePostDto {
	private int post_id;
	
	@NotBlank(message="제목은 입력은 필수입니다")
	private String title;
	private String writer;
	
	@NotBlank(message="공략 작성할 게임이름을 입력해주세요")
	private String gameName;
	
	@Size(min=20, max=400, message="최소 20자이상 최대 400자 이하로 입력해주세요")
	private String targetPost;
	private LocalDateTime writeDate;
}
