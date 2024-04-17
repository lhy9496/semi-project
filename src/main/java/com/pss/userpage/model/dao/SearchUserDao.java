package com.pss.userpage.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class SearchUserDao {
<<<<<<< HEAD

	public Member getSearchUserInfo(SqlSession sqlSession, String nickname) {
		return sqlSession.selectOne("member-mapper.SearchUserInfo", nickname);
=======
	
	public static ArrayList searchUser(SqlSession sqlSession, String nickname) {
		ArrayList<Object> list = new ArrayList<>();
		list.add(sqlSession.selectOne("member-mapper.SearchUserInfo", nickname));
		list.add(sqlSession.selectOne("member-mapper.SearchUserPhysicalInfo", nickname));
		list.add(sqlSession.selectOne("member-mapper.SearchUserPicture", nickname));
		list.add(sqlSession.selectOne("diet-mapper.SearchUserDietRecord", nickname));
		list.add(sqlSession.selectOne("exercise-mapper.SearchUserExerciseRecord", nickname));
		return list;
>>>>>>> parent of 3fed1da (Merge branch 'main' of https://github.com/lhy9496/semi-project into odg)
	}

	public UserPhysicalInfo getSearchUserPhysicalInfo(SqlSession sqlSession, String nickname) {
		return sqlSession.selectOne("member-mapper.SearchUserPhysicalInfo", nickname);
	}

	public UserPicture getSearchUserPicture(SqlSession sqlSession, String nickname) {
		return sqlSession.selectOne("member-mapper.SearchUserPicture", nickname);
	}

	public List<UserDietRecord> getSearchUserdietRecord(SqlSession sqlSession, String nickname) {
		return sqlSession.selectList("diet-mapper.SearchUserDietRecord", nickname);
	}

	public List<ExerciseRecord> getSearchUserExerciseRecord(SqlSession sqlSession, String nickname) {
		return sqlSession.selectList("exercise-mapper.SearchUserExerciseRecord", nickname);
	}
	
	

}
