package com.pss.userpage.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.pss.diet.model.vo.UserDietRecord;
import com.pss.exercise.model.vo.ExerciseRecord;
import com.pss.member.model.vo.Member;
import com.pss.member.model.vo.UserPhysicalInfo;
import com.pss.member.model.vo.UserPicture;

public class SearchUserDao {
	
	public static ArrayList searchUser(SqlSession sqlSession, String nickname) {
		ArrayList<Object> list = new ArrayList<>();
		list.add(sqlSession.selectOne("member-mapper.SearchUserInfo", nickname));
		list.add(sqlSession.selectOne("member-mapper.SearchUserPhysicalInfo", nickname));
		list.add(sqlSession.selectOne("member-mapper.SearchUserPicture", nickname));
		list.add(sqlSession.selectList("diet-mapper.SearchUserDietRecord", nickname));
		list.add(sqlSession.selectList("exercise-mapper.SearchUserExerciseRecord", nickname));
			
		return list;
	}

}
