package com.movieAndgame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.MovieReviewDaoImpl;
import com.movieAndgame.Dto.MovieReviewDto;

@Service
public class MovieReviewService {
	@Autowired
	private MovieReviewDaoImpl movieReviewDao;
	
	public void save(MovieReviewDto movieReviewDto) {
		movieReviewDao.reviewSave(movieReviewDto);
	}
	
	public List<MovieReviewDto> load(){
		return movieReviewDao.reviewLoad();
	}

	public MovieReviewDto findById(int id) {
		return movieReviewDao.findById(id);
		
	}
}
