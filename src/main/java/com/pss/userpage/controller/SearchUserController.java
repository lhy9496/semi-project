package com.pss.userpage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pss.diet.model.vo.UserDietRecord;
import com.pss.exercise.model.vo.ExerciseRecord;
import com.pss.member.model.vo.Member;
import com.pss.member.model.vo.UserInfo;
import com.pss.member.model.vo.UserPhysicalInfo;
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
		
		HashMap SearchUserTotalInfoMap = new SearchUserServiceImpl().getSearchUserTotalInfo(nickname);
		
<<<<<<< HEAD
		if (SearchUserTotalInfoMap.get("SearchUserInfo") == null) {
=======
		list = new SearchUserServiceImpl().searchUser(nickname);
		
		if ((UserInfo)list.get(0) == null) {
>>>>>>> parent of 3fed1da (Merge branch 'main' of https://github.com/lhy9496/semi-project into odg)
			request.setAttribute("alertMsg", "존재하지 않는 유저입니다.");
			response.sendRedirect(request.getContextPath());
			
			request.getRequestDispatcher(request.getContextPath()).forward(request, response);
			
		} else {
<<<<<<< HEAD
			request.setAttribute("SearchUserTotalInfo", SearchUserTotalInfoMap);
=======
			request.setAttribute("UserInfo", (UserInfo)list.get(0));
			request.setAttribute("UserPhysicalInfo", (UserPhysicalInfo)list.get(1));
			request.setAttribute("dietRecord", (UserDietRecord)list.get(2));
			request.setAttribute("exerciseRecord", (ExerciseRecord)list.get(3));
>>>>>>> parent of 3fed1da (Merge branch 'main' of https://github.com/lhy9496/semi-project into odg)
			
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
