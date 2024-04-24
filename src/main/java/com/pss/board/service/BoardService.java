package com.pss.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.pss.board.model.vo.Board;
import com.pss.board.model.vo.Reply;
import com.pss.common.vo.PageInfo;

public interface BoardService {

	//게시판리스트 조회
		public int selectListCount();
		public ArrayList<Board> selectList(PageInfo pi);
		
		//게시글 검색
		public int selectSearchCount(HashMap<String, String> map);
		public ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi);

		//게시글 상세조회
		public Board increaseCount(int boardNo);
		public ArrayList<Reply> selectReplyList(int boardNo);
		
		
		public int insertReply(Reply r);
		
		public int insertBoard(Board board);
		
		
		
}
