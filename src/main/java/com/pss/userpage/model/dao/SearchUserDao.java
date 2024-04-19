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
		return sqlSession.selectOne("memberMapper.SearchUserInfo", nickname);
	}

	public UserPhysicalInfo getSearchUserPhysicalInfo(SqlSession sqlSession, String nickname) {
		return sqlSession.selectOne("memberMapper.SearchUserPhysicalInfo", nickname);
	}

	public UserPicture getSearchUserPicture(SqlSession sqlSession, String nickname) {
		return sqlSession.selectOne("memberMapper.SearchUserPicture", nickname);
	}

	public List<UserDietRecord> getSearchUserdietRecord(SqlSession sqlSession, String nickname) {
		return sqlSession.selectList("dietMapper.SearchUserDietRecord", nickname);
	}

	public List<ExerciseRecord> getSearchUserExerciseRecord(SqlSession sqlSession, String nickname) {
		return sqlSession.selectList("exerciseMapper.selectExerciseRecordList", nickname);
	}
	
	

}
