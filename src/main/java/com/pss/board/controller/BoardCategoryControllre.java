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
import com.pss.common.mybatis_template.Pagination;
import com.pss.common.vo.PageInfo;

/**
 * Servlet implementation class BoardDetailController
 */
@WebServlet("/boardCategory.bo")
public class BoardCategoryControllre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardCategoryControllre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int category = Integer.parseInt(request.getParameter("category"));
    	int listCount = 0;
    	
    	if (category > 0) {
    		listCount = new BoardServiceImpl().selectCategoryCount(category);
    	} else {
    		listCount = new BoardServiceImpl().selectListCount();
    	}
    	
		System.out.println(listCount);
		int currentPage = Integer.parseInt(request.getParameter("cpage"));
		
		PageInfo pi = Pagination.getPageInfo(listCount, currentPage, 10, 10);
		ArrayList<Board> list = new ArrayList();
		
		if (category > 0) {
    		list = new BoardServiceImpl().selectCategoryList(pi, category);
    	} else {
    		list = new BoardServiceImpl().selectList(pi);
    	}
		
		System.out.println(list);
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
