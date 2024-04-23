package com.pss.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pss.board.model.vo.Board;
import com.pss.board.model.vo.Reply;
import com.pss.board.service.BoardService;
import com.pss.board.service.BoardServiceImpl;
import com.pss.member.model.vo.Member;

/**
 * Servlet implementation class BoardDetailController
 */
@WebServlet("/rlist.bo")
public class BoardReplyListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReplyListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int boardNo = Integer.parseInt(request.getParameter("bno"));
    	
    	ArrayList<Reply> list = new BoardServiceImpl().selectReplyList(boardNo);
    	
    	response.setContentType("application/json; charset=utf-8");
    	new Gson().toJson(list, response.getWriter());
    	
    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
