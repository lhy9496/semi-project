package com.pss.exercise.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.pss.exercise.model.vo.Exercise;
import com.pss.exercise.model.vo.ExerciseRecord;

public class ExerciseDao {

	public ArrayList<Exercise> selectExerciseList(SqlSession sqlSession) {
		return (ArrayList)sqlSession.selectList("exerciseMapper.selectExerciseList");

	}

	public int insertExerciseRecord(SqlSession sqlSession, HashMap<String, Integer> map) {
		return sqlSession.insert("exerciseMapper.insertExerciseRecord", map);
	}

}
