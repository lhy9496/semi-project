package com.pss.exercise.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.pss.common.mybatis_template.Template;
import com.pss.exercise.model.dao.ExerciseDao;
import com.pss.exercise.model.vo.Exercise;
import com.pss.exercise.model.vo.ExerciseRecord;

public class ExerciseServiceImpl implements ExerciseService{

	private ExerciseDao exerciseDao = new ExerciseDao();
	
	@Override
	public ArrayList<Exercise> selectExerciseList() {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Exercise> exList = exerciseDao.selectExerciseList(sqlSession);
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
		return result;
	}

	@Override
	public ArrayList<ExerciseRecord> selectExerciseRecordList() {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<ExerciseRecord> list = exerciseDao.selectExerciseRecordList(sqlSession);
		return list;
	}	
}
