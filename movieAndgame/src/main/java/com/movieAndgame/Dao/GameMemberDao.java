package com.movieAndgame.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndgame.Dto.GameMember;

@Mapper
public interface GameMemberDao {
	public int insert(GameMember gameMember);
}
