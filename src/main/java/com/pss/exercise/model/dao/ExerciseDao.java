package com.pss.exercise.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.pss.exercise.model.vo.Exercise;
import com.pss.exercise.model.vo.ExerciseRecord;

public class ExerciseDao {

	public ArrayList<Exercise> selectExerciseList(SqlSession sqlSession) {
		return (ArrayList)sqlSession.selectList("exerciseMapper.selectExerciseList");

	}
	
	public int insertWorkoutRecord(SqlSession sqlSession, ExerciseRecord exRecord) {
		
		return sqlSession.insert("exerciseRecordMapper", exRecord);
	}

}
