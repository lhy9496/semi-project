package com.pss.exercise.service;

import java.util.ArrayList;

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
	public int insertWorkoutRecord(String exName, ExerciseRecord exRecord) {
		SqlSession sqlSession = Template.getSqlSession();
		exerciseDao.insertWorkoutRecord(sqlSession, exRecord);
		return 0;
	}
	

}
