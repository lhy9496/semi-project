package com.pss.userpage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pss.diet.model.dao.DietRecord;
import com.pss.exercise.model.vo.ExerciseRecord;
import com.pss.userpage.service.SearchUserServiceImpl;

/**
 * Servlet implementation class ExerciseRecordController
 */
@WebServlet("/exerciseRecord.me")
public class ExerciseRecordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExerciseRecordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String nickname = request.getParameter("userNickname");
		
		ArrayList<ExerciseRecord> exerciseList = new SearchUserServiceImpl().getSearchUserExerciseRecord(nickname);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
