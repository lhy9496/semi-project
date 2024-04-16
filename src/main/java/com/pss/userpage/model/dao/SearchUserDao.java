package com.pss.userpage.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pss.diet.model.vo.UserDietRecord;
import com.pss.exercise.model.vo.ExerciseRecord;
import com.pss.member.model.vo.Member;
import com.pss.member.model.vo.UserPhysicalInfo;
import com.pss.member.model.vo.UserPicture;

public class SearchUserDao {

	public Member getSearchUserInfo(SqlSession sqlSession, String nickname) {
		return sqlSession.selectOne("member-mapper.SearchUserInfo", nickname);
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
