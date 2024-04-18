package com.pss.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.pss.board.model.dao.BoardDao;
import com.pss.board.model.vo.Board;
import com.pss.common.mybatis_template.Template;
import com.pss.common.vo.PageInfo;


public class BoardServiceImpl implements BoardService{

	private BoardDao bDao = new BoardDao();
	
	@Override
	//게시글의 총 갯수를 조회하는 메서드
	public int selectListCount() { 
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = bDao.selectListCount(sqlSession);
		
		sqlSession.close();
		
		return listCount;
	}

	@Override
	//페이징 처리된 게시글 목록을 조회하는 메서드 PageInfo객체를 통해 페이징정보를 받는다.
	public ArrayList<Board> selectList(PageInfo pi) { 
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = bDao.selectList(sqlSession, pi);
		
		sqlSession.close();
		
		return list;

	}

	@Override
	//검색 조건을 만족하는 게시글의 총 갯수를 조회
	public int selectSearchCount(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		int searchCount = bDao.selectSearchCount(sqlSession, map);
		
		sqlSession.close();
		
		return searchCount;
	}

	@Override
	// 검색조건을 만족하는 페이징처리된 게시글 목록을 조회하는 메서드
	//검색 조건과 페이징 정보를 매개변수로 받는다.
	public ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = bDao.selectSearchList(sqlSession, map, pi);
		
		sqlSession.close();
		return list;
	}

	@Override
	//특정 게시글의 조회수를 증가시키는 메서드
	//해당 게시글 번호를 받아와서 조회수를 증가시키고
	//증가된 조회수를 갖는 해당 게시글을 반환
	public Board increaseCount(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = bDao.increaseCount(sqlSession, boardNo);
		
		Board b = null;
		if (result > 0) {
			sqlSession.commit();
			b = bDao.selectBoard(sqlSession, boardNo);
		} else {
			sqlSession.rollback();
		}
		
		return b;
	}

}
