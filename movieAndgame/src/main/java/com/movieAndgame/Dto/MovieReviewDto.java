package com.movieAndgame.Dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieReviewDto {
	private int review_id;
	
	@NotBlank(message="제목은 꼭 입력하세요")
	private String title;
	
	private String writer;
	
	@Size(min=10, max=300, message="최소 10자이상 최대 300자 이하로 입력해주세요")
	private String content;
	private LocalDateTime write_date;
}
