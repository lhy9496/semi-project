package com.pss.exercise.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.pss.common.mybatis_template.Template;
import com.pss.exercise.model.dao.ExerciseDao;
import com.pss.exercise.model.vo.Exercise;
import com.pss.exercise.model.vo.ExerciseRecord;
import com.pss.member.model.dao.MemberDao;

public class ExerciseServiceImpl implements ExerciseService{

	private ExerciseDao exerciseDao = new ExerciseDao();
	
	@Override
	public ArrayList<Exercise> selectExerciseList() {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Exercise> exList = exerciseDao.selectExerciseList(sqlSession);
		sqlSession.close();
		return exList;
	}
	
	@Override
	public int insertExerciseRecord(HashMap<String, Integer> map) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = exerciseDao.insertExerciseRecord(sqlSession, map);
		if(result > 0 ) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}

	@Override
	public ArrayList<ExerciseRecord> selectExerciseRecordList(int userNo) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<ExerciseRecord> list = exerciseDao.selectExerciseRecordList(sqlSession,userNo);
		sqlSession.close();
		return list;
	}

	@Override
	public ArrayList<ExerciseRecord> selectClickedDateWorkoutList(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<ExerciseRecord> list = exerciseDao.selectClickedDateWorkoutList(sqlSession, map);
		
		
		sqlSession.close();
		return list;
	}	
}
