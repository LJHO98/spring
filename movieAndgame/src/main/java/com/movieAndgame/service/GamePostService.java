package com.movieAndgame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.GamePostDao;
import com.movieAndgame.Dto.GamePostDto;

@Service
public class GamePostService {
	@Autowired
	private GamePostDao gamePostDao;
	
	public void postSave(GamePostDto gamePostDto ) {
		gamePostDao.save(gamePostDto);
	}
	
	public List<GamePostDto> postList(){
		return gamePostDao.findAll();
	}

	public GamePostDto findById(int id) {
		return gamePostDao.findById(id);
	}
}
