package com.pss.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pss.board.model.vo.Board;
import com.pss.board.model.vo.Reply;
import com.pss.board.service.BoardService;
import com.pss.board.service.BoardServiceImpl;

/**
 * Servlet implementation class BoardDetailController
 */
@WebServlet("/detail.bo")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		BoardService bService = new BoardServiceImpl();
		//조회수 증가 + 상세조회
		Board b = bService.increaseCount(boardNo);
		
		if (b != null) {
			ArrayList<Reply> list = bService.selectReplyList(boardNo);
			request.setAttribute("b", b);
			request.setAttribute("rlist", list);
			
			request.getRequestDispatcher("views/board/boardDetailView.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "상세조회 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
