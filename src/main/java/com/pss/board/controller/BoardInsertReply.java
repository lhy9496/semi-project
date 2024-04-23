package com.pss.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pss.board.model.vo.Board;
import com.pss.board.model.vo.Reply;
import com.pss.board.service.BoardService;
import com.pss.board.service.BoardServiceImpl;
import com.pss.member.model.vo.Member;

/**
 * Servlet implementation class BoardDetailController
 */
@WebServlet("/rinsert.bo")
public class BoardInsertReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertReply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	int boardNo = Integer.parseInt(request.getParameter("bno"));
    	String replyContent = request.getParameter("content");
    	int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();    
    	
    	Reply r = new Reply();
    	r.setRefBoardNo(boardNo);
    	r.setReplyContent(replyContent);
    	r.setReplyWriter(String.valueOf(userNo));
    	
    	BoardService bService = new BoardServiceImpl();
    	
    	int result = bService.insertReply(r);
    	
    	response.getWriter().print(result);
    	
    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
