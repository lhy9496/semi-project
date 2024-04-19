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
 * Servlet implementation class MyPageController
 */
@WebServlet("/menuToUserPage.me")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String nickname = (String)(request.getSession().getAttribute("userNickname"));
		
		HashMap<String, Object> searchUserTotalInfoMap = new SearchUserServiceImpl().getSearchUserTotalInfo(nickname);
		
		if (searchUserTotalInfoMap.get("SearchUserInfo") == null) {
			request.setAttribute("alertMsg", "페이지를 가져오는데 실패하였습니다.");
			response.sendRedirect(request.getContextPath());
		} else {

			request.setAttribute("SearchUserTotalInfoMap", searchUserTotalInfoMap);

			request.getRequestDispatcher("/views/userpage/userpage.jsp").forward(request, response);
			
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
