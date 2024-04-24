package com.pss.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pss.board.model.vo.Board;
import com.pss.board.service.BoardService;
import com.pss.board.service.BoardServiceImpl;
import com.pss.member.model.vo.Member;

/**
 * Servlet implementation class BoardDetailController
 */
@WebServlet("/insert.bo")
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int userNo = ((Member)(request.getSession().getAttribute("loginUser"))).getUserNo();
		
		int category = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		
		
		Board b = new Board();
		
		b.setBoardTitle(title);
		b.setBoardContent(content);
		b.setCategoryNo(category);
		b.setBoardWriter(String.valueOf(userNo));
		
		BoardService bService = new BoardServiceImpl();
		
		int result = bService.insertBoard(b);
			
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "일반게시글 작성 성공");
			response.sendRedirect(request.getContextPath() + "/list.bo?cpage=1");
		}else {
			request.setAttribute("errorMsg", "일반게시글 작성 실패");
			request.getRequestDispatcher("views/board/boardListView.jsp").forward(request, response);
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
