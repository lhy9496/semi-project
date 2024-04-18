package com.pss.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.pss.board.model.vo.Board;
import com.pss.common.vo.PageInfo;

public interface BoardService {

	//게시판리스트 조회
	public int selectListCount();
	public ArrayList<Board> selectList(PageInfo pi);
	
	//게시글 검색
	int selectSearchCount(HashMap<String, String> map);
	ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi);
	
	Board increaseCount(int boardNo);
}
