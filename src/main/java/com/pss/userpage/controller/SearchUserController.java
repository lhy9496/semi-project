package com.pss.userpage.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pss.userpage.service.SearchUserServiceImpl;

/**
 * Servlet implementation class SearchUserController
 */
@WebServlet("/search.me")
public class SearchUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SearchUserController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String nickname = request.getParameter("nickname");
		
		HashMap<String, Object> searchUserTotalInfoMap = new SearchUserServiceImpl().getSearchUserTotalInfo(nickname);
		

		if (searchUserTotalInfoMap.get("SearchUserInfo") == null) {
			request.setAttribute("alertMsg", "존재하지 않는 유저입니다.");
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("searchUserTotalInfoMap", searchUserTotalInfoMap);
			
			request.getRequestDispatcher("/views/userpage/userpage.jsp").forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}