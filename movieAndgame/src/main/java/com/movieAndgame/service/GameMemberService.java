package com.movieAndgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.GameMemberDao;
import com.movieAndgame.Dto.GameMember;

@Service
public class GameMemberService {
	
	@Autowired
	GameMemberDao gameMemberDao;
	
	public void signUpSave(GameMember gameMember) {
		gameMemberDao.insert(gameMember);
	}
	
	public GameMember login(GameMember gameMember) {
		return gameMemberDao.login(gameMember);
	}
}
