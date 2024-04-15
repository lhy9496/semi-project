package com.pss.userpage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pss.diet.model.vo.UserDietRecord;
import com.pss.exercise.model.vo.Exercise;
import com.pss.member.model.vo.Member;
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
		
		ArrayList<Object> list = new ArrayList<>();
		
		list = new SearchUserServiceImpl().searchUser(nickname);
		
		if ((Member)list.get(0) == null) {
			request.setAttribute("errorMsg", "존재하지 않는 유저입니다.");
			response.sendRedirect(request.getContextPath());
		} else {
			request.getSession().setAttribute("searchUser", (Member)list.get(0));
			request.getSession().setAttribute("diet", (UserDietRecord)list.get(1));
			request.getSession().setAttribute("exercise", (Exercise)list.get(2));
			request.getRequestDispatcher("WEB-INF/views/userpage/userpage.jsp").forward(request, response);
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
