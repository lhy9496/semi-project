package com.pss.userpage.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

public class SearchUserDao {
	
	public static ArrayList searchUser(SqlSession sqlSession, String nickname) {
		ArrayList<Object> list = new ArrayList<>();
		list.add(sqlSession.selectOne("userpage-mapper.SearchUserInfo", nickname));
		list.add(sqlSession.selectOne("userpage-mapper.SearchUserPhysicalInfo", nickname));
		list.add(sqlSession.selectOne("userpage-mapper.SearchUserDietRecord", nickname));
		list.add(sqlSession.selectOne("userpage-mapper.SearchUserExerciseRecord", nickname));
		return list;
	}

}
