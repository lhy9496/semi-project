package com.pss.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pss.board.model.vo.Board;
import com.pss.board.service.BoardService;
import com.pss.board.service.BoardServiceImpl;
import com.pss.common.mybatis_template.Pagination;
import com.pss.common.vo.PageInfo;


/**
 * Servlet implementation class BoardSearchController
 */
@WebServlet("/searchCategory.bo")
public class BoardSearchCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchCategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condition = request.getParameter("condition"); // writer || title || content
		String keyword = request.getParameter("keyword"); //사용자가 입력한 키워드값
		String category = request.getParameter("category");
		
		HashMap<String, String> map = new HashMap<>();
		map.put("condition", condition);
		map.put("keyword", keyword);
		map.put("category", category);
		
		BoardService bService = new BoardServiceImpl();
		int searchCount = bService.selectSearchCategoryCount(map);
		int currentPage = Integer.parseInt(request.getParameter("cpage")); //페이지정보
		
		PageInfo pi = Pagination.getPageInfo(searchCount, currentPage, 10 , 10);
		ArrayList<Board> list = bService.selectSearchCategoryList(map, pi);
		
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		request.setAttribute("condition", condition);
		request.setAttribute("keyword", keyword);
		
		request.getRequestDispatcher("views/board/boardCategoryView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
