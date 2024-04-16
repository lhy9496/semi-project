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
import com.pss.exercise.model.vo.ExerciseRecord;
import com.pss.member.model.vo.Member;
import com.pss.member.model.vo.UserPhysicalInfo;
import com.pss.member.model.vo.UserPicture;
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
			request.setAttribute("alertMsg", "존재하지 않는 유저입니다.");
			response.sendRedirect(request.getContextPath());
			
			request.getRequestDispatcher(request.getContextPath()).forward(request, response);
			
		} else {
			request.setAttribute("SearchUserInfo", (Member)list.get(0));
			request.setAttribute("SearchUserPhysicalInfo", (UserPhysicalInfo)list.get(1));
			request.setAttribute("SearchUserPicture", (UserPicture)list.get(2));
			request.setAttribute("SearchUserdietRecord", (ArrayList<UserDietRecord>)list.get(3));
			request.setAttribute("SearchUserExerciseRecord", (ArrayList<ExerciseRecord>)list.get(4));
			
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
