package com.pss.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.pss.board.model.dao.BoardDao;
import com.pss.board.model.vo.Board;
import com.pss.board.model.vo.Reply;
import com.pss.common.mybatis_template.Template;
import com.pss.common.vo.PageInfo;

public class BoardServiceImpl implements BoardService{

	private BoardDao bDao = new BoardDao();
	
	@Override
	public int selectListCount() {
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = bDao.selectListCount(sqlSession);
		
		sqlSession.close();
		
		return listCount;
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = bDao.selectList(sqlSession, pi);
		
		sqlSession.close();
		
		return list;

	}

	@Override
	public int selectSearchCount(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		int searchCount = bDao.selectSearchCount(sqlSession, map);
		
		sqlSession.close();
		
		return searchCount;
	}

	@Override
	public ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = bDao.selectSearchList(sqlSession, map, pi);
		
		sqlSession.close();
		return list;
	}

	@Override
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
		
		sqlSession.close();
		
		return b;
	}

	@Override
	public ArrayList<Reply> selectReplyList(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Reply> list = bDao.selectReplyList(sqlSession, boardNo);
		
		sqlSession.close();
		
		return list;
	}

	@Override
	public int insertReply(Reply r) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = Template.getSqlSession();
		int result = bDao.insertReply(sqlSession, r);
		
		if(result > 0) {
			sqlSession.commit();
			
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
	
	@Override
	public int insertBoard(Board board) {
		
		SqlSession sqlSession = Template.getSqlSession();
		int result = bDao.insertBoard(sqlSession, board);
		
		if(result > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result;
	}
	
	@Override
	public int selectCategoryCount (int category) {
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = bDao.selectCategoryCount(sqlSession, category);
		
		sqlSession.close();
		
		return listCount;
	}
	
	@Override
	public ArrayList<Board> selectCategoryList(PageInfo pi, int category) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = bDao.selectCategoryList(sqlSession, pi, category);
		
		sqlSession.close();
		
		return list;
	}
	
	@Override
	public int selectSearchCategoryCount(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		int searchCount = bDao.selectSearchCategoryCount(sqlSession, map);
		
		sqlSession.close();
		
		return searchCount;
	}

	@Override
	public ArrayList<Board> selectSearchCategoryList(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = bDao.selectSearchCategoryList(sqlSession, map, pi);
		
		sqlSession.close();
		return list;
	}
}
